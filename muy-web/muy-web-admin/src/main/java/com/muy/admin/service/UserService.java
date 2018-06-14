package com.muy.admin.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.muy.admin.model.domain.RoleMenuDO;
import com.muy.admin.model.domain.UserDO;
import com.muy.admin.model.domain.UserGroupDO;
import com.muy.admin.model.domain.UserRoleDO;
import com.muy.admin.model.query.CreateUserQuery;
import com.muy.admin.model.query.DeleteUserQuery;
import com.muy.admin.model.query.LoadPageQuery;
import com.muy.admin.model.query.SaveUserQuery;
import com.muy.admin.model.vo.CreateUserVO;
import com.muy.admin.model.vo.LoginUserVO;
import com.muy.admin.repository.RoleMenuRepository;
import com.muy.admin.repository.UserGroupRepository;
import com.muy.admin.repository.UserRepository;
import com.muy.admin.repository.UserRoleRepository;
import com.muy.base.constant.GlobalConstant;
import com.muy.base.enums.ErrorCodeEnum;
import com.muy.base.enums.UserSourceEnum;
import com.muy.base.exception.BizException;
import com.muy.util.crypto.encryptor.EncryptorsUtil;
import com.muy.util.mapper.MapperUtil;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yanglikai on 2018/5/24.
 */
@Service
public class UserService {
  @Resource
  private UserRepository userRepository;
  @Resource
  private UserGroupRepository userGroupRepository;
  @Resource
  private UserRoleRepository userRoleRepository;
  @Resource
  private RoleMenuRepository roleMenuRepository;

  /**
   * 保存/更新用户.
   * @param query
   * @return
   */
  @Transactional(rollbackFor = Exception.class)
  public boolean saveUser(SaveUserQuery query) {
    String rawPassword = "123456";
    String salt = EncryptorsUtil.generateKey();
    String hashPassword = EncryptorsUtil.sha256(EncryptorsUtil.sha256(rawPassword) + salt);

    /* 保存用户信息 */
    UserDO user = MapperUtil.map(query, UserDO.class);
    user.setPassword(hashPassword);
    user.setSalt(salt);
    user.setUserSource(UserSourceEnum.INSERT.code);
    userRepository.save(user);

    /* 保存用户组织信息 */
    String groupCode = query.getPosition().size() > 0 ? query.getPosition().get(0) : "";
    UserGroupDO userGroup = new UserGroupDO();
    userGroup.setUserId(user.getId());
    userGroup.setGroupCode(groupCode);
    userGroupRepository.save(userGroup);

    /* 保存用户角色信息 */
    String roleCode = query.getPosition().size() > 1 ? query.getPosition().get(1) : "";
    UserRoleDO userRole = new UserRoleDO();
    userRole.setUserId(user.getId());
    userRole.setRoleCode(roleCode);
    userRoleRepository.save(userRole);

    return true;
  }

  /**
   * 删除用户.
   *
   * @param query
   * @return
   */
  public boolean deleteUser(DeleteUserQuery query) {
    return userRepository.deleteById(query.getUserId());
  }

  /**
   * 创建用户
   *
   * @param query
   * @return
   */
  @Transactional(rollbackFor = Exception.class)
  public CreateUserVO createUser(CreateUserQuery query) {
    String rawPassword = query.getPassword();
    String salt = EncryptorsUtil.generateKey();
    String hashPassword = EncryptorsUtil.sha256(EncryptorsUtil.sha256(rawPassword) + salt);

    /* 保存用户信息 */
    UserDO user = MapperUtil.map(query, UserDO.class);
    user.setPassword(hashPassword);
    user.setSalt(salt);
    user.setUserSource(UserSourceEnum.REGISTER.code);
    userRepository.save(user);

    /* 保存用户组织信息 */
    UserGroupDO userGroup = new UserGroupDO();
    userGroup.setUserId(user.getId());
    userGroup.setGroupCode(query.getGroupCode());
    userGroupRepository.save(userGroup);

    /* 保存用户角色信息 */
    UserRoleDO userRole = new UserRoleDO();
    userRole.setUserId(user.getId());
    userRole.setRoleCode(query.getRoleCode());
    userRoleRepository.save(userRole);

    return
        CreateUserVO.builder()
            .userId(user.getId())
            .userName(user.getUserName())
            .build();
  }

  /**
   * 加载用户信息.
   *
   * @param userId
   * @return
   */
  public LoginUserVO loadUser(Long userId) {
    UserDO user = userRepository.selectByUid(userId);
    if (user == null) {
      throw new BizException(ErrorCodeEnum.UMC10012001);
    }

    /* 获取角色 */
    UserRoleDO userRole = userRoleRepository.select(userId);
    if (userRole == null) {
      throw new BizException(ErrorCodeEnum.UMC10012003);
    }

    /* 获取该角色下菜单信息 */
    String roleCode = userRole.getRoleCode();
    List<RoleMenuDO> menus = roleMenuRepository.selectByRoleCode(roleCode);
    if (menus == null) {
      throw new BizException(ErrorCodeEnum.UMC10012004);
    }

    List<String> menuIdList =
        menus.stream()
            .map(el -> el.getMenuId())
            .map(el -> el.toString())
            .collect(Collectors.toList());

    return
        LoginUserVO.builder()
            .userId(userId)
            .userName(user.getUserName())
            .permissions(
                LoginUserVO.Permissions.builder()
                    .visit(menuIdList)
                    .role(roleCode)
                    .build())
            .build();
  }

  /**
   * 根据用户名加载用户信息.
   *
   * @param userName
   * @return
   */
  public UserDO loadUserByUsername(String userName) {
    return userRepository.selectByUsername(userName);
  }

  /**
   * 用户认证.
   *
   * @param userName
   * @param rawPassword
   * @return
   */
  public UserDO authUser(String userName, String rawPassword) {
    /* 用户有效性验证 */
    UserDO user = loadUserByUsername(userName);
    if (user == null) {
      throw new BizException(ErrorCodeEnum.UMC10012001);
    }

    /* 密码有效性验证 */
    String salt = user.getSalt();
    String original = user.getPassword();
    String hashPassword = EncryptorsUtil.sha256(EncryptorsUtil.sha256(rawPassword) + salt);
    boolean isValid = EncryptorsUtil.slowEquals(original, hashPassword);
    if (isValid == false) {
      throw new BizException(ErrorCodeEnum.UMC10012001);
    }

    return user;
  }

  /**
   * 根据手机号加载用户信息.
   *
   * @param mobile
   * @return
   */
  public UserDO loadUserByMobile(String mobile) {
    return userRepository.selectByMobile(mobile);
  }

  /**
   * 分页加载.
   *
   * @param query
   * @return
   */
  public Page<UserDO> loadPage(LoadPageQuery query) {
    int page = query.getPage() == null ? 1 : query.getPage();
    int size = query.getPageSize() == null ? GlobalConstant.DEFAULT_PAGE_SIZE : query.getPageSize();

    return userRepository.selectPage(
        new Page<>(page, size),
        new EntityWrapper().orderBy("create_time", false));
  }
}
