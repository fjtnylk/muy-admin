package com.muy.admin.repository;

import com.baomidou.mybatisplus.service.IService;
import com.muy.admin.model.domain.MasterRoleDO;
import java.util.List;

/**
 * Created by yanglikai on 2018/5/23.
 */
public interface MasterRoleRepository extends IService<MasterRoleDO> {

  /**
   * 查询所有角色信息.
   *
   * @return
   */
  List<MasterRoleDO> selectAll();
}
