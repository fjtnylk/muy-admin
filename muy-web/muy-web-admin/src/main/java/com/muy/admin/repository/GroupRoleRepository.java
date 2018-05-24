package com.muy.admin.repository;

import com.baomidou.mybatisplus.service.IService;
import com.muy.admin.model.domain.GroupRoleDO;
import java.util.List;

/**
 * Created by yanglikai on 2018/5/24.
 */
public interface GroupRoleRepository extends IService<GroupRoleDO> {

  /**
   * 保存/更新组织角色信息.
   *
   * @param target
   * @return
   */
  boolean save(GroupRoleDO target);

  /**
   * 批量保存/更新组织角色信息.
   *
   * @param target
   * @return
   */
  boolean save(List<GroupRoleDO> target);

  /**
   * 删除指定组织角色信息.
   *
   * @param gCode
   * @return
   */
  boolean delete(String gCode);

  /**
   * 查询指定组织角色信息.
   *
   * @param gCode
   * @return
   */
  List<GroupRoleDO> selectByGroupCode(String gCode);

  /**
   * 查询所有组织角色信息.
   *
   * @return
   */
  List<GroupRoleDO> selectAll();
}
