package com.muy.admin.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.muy.admin.model.domain.MasterGroupDO;
import com.muy.admin.model.domain.MasterMenuDO;
import com.muy.admin.model.domain.MasterRoleDO;
import com.muy.admin.model.query.SaveGroupQuery;
import com.muy.admin.model.query.SaveMenuQuery;
import com.muy.admin.model.query.SaveRoleQuery;
import com.muy.admin.repository.GroupRoleRepository;
import com.muy.admin.repository.MasterGroupRepository;
import com.muy.admin.repository.MasterMenuRepository;
import com.muy.admin.repository.MasterRoleRepository;
import com.muy.util.mapper.MapperUtil;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 系统设置.
 * Created by yanglikai on 2018/5/22.
 */
@Service
public class SystemSettingService {
  @Resource
  private MasterGroupRepository groupRepository;
  @Resource
  private MasterRoleRepository roleRepository;
  @Resource
  private MasterMenuRepository menuRepository;
  @Resource
  private GroupRoleRepository groupRoleRepository;

  // ============================================Group start=============================================

  /**
   * 保存/更新组织信息.
   *
   * @param query
   * @return
   */
  public boolean save4Group(SaveGroupQuery query) {
    MasterGroupDO target = MapperUtil.map(query, MasterGroupDO.class);
    return groupRepository.save(target);
  }

  /**
   * 批量保存/更新组织信息.
   *
   * @param query
   * @return
   */
  public boolean saveBatch4Group(List<SaveGroupQuery> query) {
    List<MasterGroupDO> target = MapperUtil.map(query, MasterGroupDO.class);
    return groupRepository.saveBatch(target);
  }

  /**
   * 删除组织信息.
   *
   * @param groupCode
   * @return
   */
  @Transactional(rollbackFor = Exception.class)
  public boolean delete4Group(String groupCode) {
    groupRepository.delete(groupCode);
    groupRoleRepository.delete(groupCode);
    return true;
  }

  /**
   * 批量删除组织信息.
   *
   * @param groupCodeList
   * @return
   */
  public boolean deleteBatch4Group(List<String> groupCodeList) {
    return groupRepository.deleteBatch(groupCodeList);
  }

  /**
   * 加载所有组织信息.
   *
   * @return
   */
  public List<MasterGroupDO> loadAll4Group() {
    return groupRepository.selectAll();
  }

  /**
   * 分页加载组织信息.
   *
   * @param page
   * @param size
   * @return
   */
  public Page<MasterGroupDO> loadPage4Group(int page, int size) {
    return
        groupRepository.selectPage(
            new Page<>(page, size),
            new EntityWrapper<MasterGroupDO>().orderBy("create_time", false));
  }

  /**
   * 加载单条组织信息.
   *
   * @param groupCode
   * @return
   */
  public MasterGroupDO loadSignle4Group(String groupCode) {
    return groupRepository.selectSignle(groupCode);
  }

  // ============================================Group end  =============================================

  // ============================================Role start=============================================

  /**
   * 保存/更新角色信息.
   *
   * @param query
   * @return
   */
  public boolean save4Role(SaveRoleQuery query) {
    MasterRoleDO target = MapperUtil.map(query, MasterRoleDO.class);

    return roleRepository.save(target);
  }

  /**
   * 批量保存/更新角色信息.
   *
   * @param query
   * @return
   */
  public boolean saveBatch4Role(List<SaveRoleQuery> query) {
    List<MasterRoleDO> target = MapperUtil.map(query, MasterRoleDO.class);

    return roleRepository.saveBatch(target);
  }

  /**
   * 删除角色信息.
   *
   * @param roleCode
   * @return
   */
  public boolean delete4Role(String roleCode) {
    return roleRepository.delete(roleCode);
  }

  /**
   * 批量删除角色信息.
   *
   * @param roleCodeList
   * @return
   */
  public boolean deleteBatch4Role(List<String> roleCodeList) {
    return roleRepository.deleteBatch(roleCodeList);
  }

  /**
   * 加载单个角色信息.
   *
   * @param roleCode
   * @return
   */
  public MasterRoleDO loadSignle4Role(String roleCode) {
    return roleRepository.selectSignle(roleCode);
  }

  /**
   * 加载所有角色信息.
   *
   * @return
   */
  public List<MasterRoleDO> loadAll4Role() {
    return roleRepository.selectAll();
  }

  /**
   * 分页加载.
   *
   * @param current
   * @param size
   * @return
   */
  public Page<MasterRoleDO> loadPage4Role(Integer current, Integer size) {
    return roleRepository.selectPage(
        new Page<>(current, size),
        new EntityWrapper().orderBy("create_time", false));
  }
  // ============================================Role end  =============================================

  // ============================================Menu start=============================================

  /**
   * 保存/更新菜单.
   *
   * @param query
   * @return
   */
  public boolean save4Menu(SaveMenuQuery query) {
    MasterMenuDO target = MapperUtil.map(query, MasterMenuDO.class);

    return menuRepository.save(target);
  }

  /**
   * 批量保存/更新菜单.
   *
   * @param query
   * @return
   */
  public boolean saveBatch4Menu(List<SaveMenuQuery> query) {
    List<MasterMenuDO> target = MapperUtil.map(query, MasterMenuDO.class);

    return menuRepository.saveBatch(target);
  }

  /**
   * 删除菜单信息.
   *
   * @param menuId
   * @return
   */
  public boolean delete4Menu(Integer menuId) {
    return menuRepository.delete(menuId);
  }

  /**
   * 批量删除菜单信息.
   *
   * @param menuIdList
   * @return
   */
  public boolean deleteBatch4Menu(List<Integer> menuIdList) {
    return menuRepository.deleteBatch(menuIdList);
  }

  /**
   * 加载单条菜单信息.
   *
   * @param menuId
   * @return
   */
  public MasterMenuDO loadSignle4Menu(Integer menuId) {
    return menuRepository.selectSignle(menuId);
  }

  /**
   * 加载所有菜单信息.
   *
   * @return
   */
  public List<MasterMenuDO> loadAll4Menu() {
    return menuRepository.selectAll();
  }

  /**
   * 分页加载菜单信息.
   *
   * @param current
   * @param size
   * @return
   */
  public Page<MasterMenuDO> loadPage4Menu(int current, int size) {
    return
        menuRepository.selectPage(
            new Page<>(current, size),
            new EntityWrapper<MasterMenuDO>().orderBy("id", true).orderBy("create_time", false));
  }
  // ============================================Menu end  =============================================
}
