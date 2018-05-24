package com.muy.admin.service;

import com.google.common.collect.Lists;
import com.muy.admin.model.domain.GroupRoleDO;
import com.muy.admin.model.domain.RoleMenuDO;
import com.muy.admin.model.query.DeleteGroupRoleQuery;
import com.muy.admin.model.query.DeleteRoleMenuQuery;
import com.muy.admin.model.query.SaveGroupRoleQuery;
import com.muy.admin.model.query.SaveRoleMenuQuery;
import com.muy.admin.repository.RoleMenuRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Created by yanglikai on 2018/5/24.
 */
@Service
public class RoleMenuService {
  @Resource
  private RoleMenuRepository roleMenuRepository;

  /**
   * 保存/更新角色菜单信息.
   *
   * @param query
   * @return
   */
  public boolean save(SaveRoleMenuQuery query) {
    List<RoleMenuDO> target = parse(query);

    return roleMenuRepository.save(target);
  }

  /**
   * 批量保存/更新角色菜单信息.
   *
   * @param query
   * @return
   */
  public boolean save(List<SaveRoleMenuQuery> query) {
    List<RoleMenuDO> target = Lists.newArrayList();

    for (SaveRoleMenuQuery item : query) {
      target.addAll(parse(item));
    }

    return roleMenuRepository.save(target);
  }

  private List<RoleMenuDO> parse(SaveRoleMenuQuery query) {
    String roleCode = query.getRoleCode();

    List<Integer> menus =
        query.getMenus().stream()
            .map(el -> el.getMenuId())
            .collect(Collectors.toList());

    List<RoleMenuDO> target = Lists.newArrayListWithCapacity(menus.size());
    for (Integer menuId : menus) {
      RoleMenuDO entity = new RoleMenuDO();
      entity.setPkey(roleCode + "|" + menuId);
      entity.setRoleCode(roleCode);
      entity.setMenuId(menuId);

      target.add(entity);
    }

    return target;
  }

  /**
   * 删除角色菜单信息.
   *
   * @param query
   * @return
   */
  public boolean delete(DeleteRoleMenuQuery query) {
    return roleMenuRepository.delete(query.getRoleCode());
  }

  /**
   * 加载指定角色菜单信息.
   *
   * @param roleCode
   * @return
   */
  public List<RoleMenuDO> load(String roleCode) {
    return roleMenuRepository.selectByRoleCode(roleCode);
  }

  /**
   * 加载所有组织角色信息.
   *
   * @return
   */
  public List<RoleMenuDO> loadAll() {
    return roleMenuRepository.selectAll();
  }
}
