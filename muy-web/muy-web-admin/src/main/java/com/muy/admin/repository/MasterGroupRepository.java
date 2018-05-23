package com.muy.admin.repository;

import com.baomidou.mybatisplus.service.IService;
import com.muy.admin.model.domain.MasterGroupDO;
import java.util.List;

/**
 * Created by yanglikai on 2018/5/22.
 */
public interface MasterGroupRepository extends IService<MasterGroupDO> {

  /**
   * 查询所有组织信息.
   *
   * @return
   */
  List<MasterGroupDO> selectAllGroup();
}
