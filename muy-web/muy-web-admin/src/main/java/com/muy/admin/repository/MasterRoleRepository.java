package com.muy.admin.repository;

import com.baomidou.mybatisplus.service.IService;
import com.muy.admin.model.domain.MasterGroupDO;
import com.muy.admin.model.domain.MasterRoleDO;
import java.util.List;

/**
 * Created by yanglikai on 2018/5/23.
 */
public interface MasterRoleRepository extends IService<MasterRoleDO> {

  /**
   * 保存/更新角色信息.
   *
   * @param target
   * @return
   */
  boolean save(MasterRoleDO target);

  /**
   * 批量保存/更新角色信息.
   *
   * @param target
   * @return
   */
  boolean saveBatch(List<MasterRoleDO> target);

  /**
   * 删除角色.
   *
   * @param rCode
   * @return
   */
  boolean delete(String rCode);

  /**
   * 批量删除角色.
   *
   * @param rCodeList
   * @return
   */
  boolean deleteBatch(List<String> rCodeList);

  /**
   * 查询组织信息.
   *
   * @param rCode
   * @return
   */
  MasterRoleDO selectSignle(String rCode);

  /**
   * 查询所有角色信息.
   *
   * @return
   */
  List<MasterRoleDO> selectAll();
}
