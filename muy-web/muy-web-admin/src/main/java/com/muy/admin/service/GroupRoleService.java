package com.muy.admin.service;

import com.google.common.collect.Lists;
import com.muy.admin.model.domain.GroupRoleDO;
import com.muy.admin.model.query.DeleteGroupRoleQuery;
import com.muy.admin.model.query.SaveGroupRoleQuery;
import com.muy.admin.repository.GroupRoleRepository;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Created by yanglikai on 2018/5/24.
 */
@Service
public class GroupRoleService {
  @Resource
  private GroupRoleRepository groupRoleRepository;

  /**
   * 保存/更新组织角色信息.
   *
   * @param query
   * @return
   */
  public boolean save(SaveGroupRoleQuery query) {
    if (query.getRoles().size() == 0) {
      return groupRoleRepository.delete(query.getGroupCode());
    }

    List<GroupRoleDO> target = parse(query);

    return groupRoleRepository.save(target);
  }

  /**
   * 批量保存/更新组织角色信息.
   *
   * @param query
   * @return
   */
  public boolean save(List<SaveGroupRoleQuery> query) {
    List<GroupRoleDO> target = Lists.newArrayList();

    for (SaveGroupRoleQuery item : query) {
      target.addAll(parse(item));
    }

    return groupRoleRepository.save(target);
  }

  private List<GroupRoleDO> parse(SaveGroupRoleQuery query) {
    String groupCode = query.getGroupCode();

    List<String> roles = query.getRoles();

    List<GroupRoleDO> target = Lists.newArrayListWithCapacity(roles.size());
    for (String role : roles) {
      GroupRoleDO entity = new GroupRoleDO();
      entity.setPkey(groupCode + "|" + role);
      entity.setGroupCode(groupCode);
      entity.setRoleCode(role);

      target.add(entity);
    }

    return target;
  }

  /**
   * 删除组织角色信息.
   *
   * @param query
   * @return
   */
  public boolean delete(DeleteGroupRoleQuery query) {
    return groupRoleRepository.delete(query.getGroupCode());
  }

  /**
   * 加载指定组织下角色信息.
   *
   * @param groupCode
   * @return
   */
  public List<GroupRoleDO> load(String groupCode) {
    return groupRoleRepository.selectByGroupCode(groupCode);
  }

  /**
   * 加载所有组织角色信息.
   *
   * @return
   */
  public List<GroupRoleDO> loadAll() {
    return groupRoleRepository.selectAll();
  }
}
