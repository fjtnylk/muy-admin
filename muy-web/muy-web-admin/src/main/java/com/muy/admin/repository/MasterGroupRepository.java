package com.muy.admin.repository;

import com.baomidou.mybatisplus.service.IService;
import com.muy.admin.model.domain.MasterGroupDO;
import java.util.List;

/**
 * Created by yanglikai on 2018/5/22.
 */
public interface MasterGroupRepository extends IService<MasterGroupDO> {

  /**
   * 保存/更新组织信息.
   *
   * @param target
   * @return
   */
  boolean save(MasterGroupDO target);

  /**
   * 批量保存/更新组织信息.
   *
   * @param target
   * @return
   */
  boolean saveBatch(List<MasterGroupDO> target);

  /**
   * 删除组织.
   *
   * @param gCode
   * @return
   */
  boolean delete(String gCode);

  /**
   * 批量删除组织.
   *
   * @param gCodeList
   * @return
   */
  boolean deleteBatch(List<String> gCodeList);

  /**
   * 查询组织信息.
   *
   * @param gCode
   * @return
   */
  MasterGroupDO selectSignle(String gCode);

  /**
   * 查询所有组织信息.
   *
   * @return
   */
  List<MasterGroupDO> selectAll();
}
