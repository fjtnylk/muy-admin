package com.muy.admin.repository;

import com.baomidou.mybatisplus.service.IService;
import com.muy.admin.model.domain.RoleMenuDO;
import java.util.List;

/**
 * Created by yanglikai on 2018/5/24.
 */
public interface RoleMenuRepository extends IService<RoleMenuDO> {

  /**
   * 保存/更新角色菜单信息.
   *
   * @param target
   * @return
   */
  boolean save(RoleMenuDO target);

  /**
   * 批量保存/更新角色菜单信息.
   *
   * @param target
   * @return
   */
  boolean save(List<RoleMenuDO> target);

  /**
   * 删除指定角色菜单信息.
   *
   * @param rCode
   * @return
   */
  boolean delete(String rCode);

  /**
   * 查询指定角色菜单信息.
   *
   * @param rCode
   * @return
   */
  List<RoleMenuDO> selectByRoleCode(String rCode);

  /**
   * 查询所有角色菜单信息.
   *
   * @return
   */
  List<RoleMenuDO> selectAll();
}
