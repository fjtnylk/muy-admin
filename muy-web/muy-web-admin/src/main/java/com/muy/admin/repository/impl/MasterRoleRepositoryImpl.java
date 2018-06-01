package com.muy.admin.repository.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muy.admin.mapper.MasterRoleMapper;
import com.muy.admin.model.domain.MasterRoleDO;
import com.muy.admin.repository.MasterRoleRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2018/5/23.
 */
@Repository
public class MasterRoleRepositoryImpl
    extends ServiceImpl<MasterRoleMapper, MasterRoleDO> implements MasterRoleRepository {

  /**
   * 保存/更新角色信息.
   *
   * @param target
   * @return
   */
  @Override
  public boolean save(MasterRoleDO target) {
    return super.insertOrUpdate(target);
  }

  /**
   * 批量保存/更新角色信息.
   *
   * @param target
   * @return
   */
  @Override
  public boolean saveBatch(List<MasterRoleDO> target) {
    return super.insertOrUpdateBatch(target);
  }

  /**
   * 删除角色.
   *
   * @param rCode
   * @return
   */
  @Override
  public boolean delete(String rCode) {
    return super.deleteById(rCode);
  }

  /**
   * 批量删除角色.
   *
   * @param rCodeList
   * @return
   */
  @Override
  public boolean deleteBatch(List<String> rCodeList) {
    return super.deleteBatchIds(rCodeList);
  }

  /**
   * 查询组织信息.
   *
   * @param rCode
   * @return
   */
  @Override
  public MasterRoleDO selectSignle(String rCode) {
    return
        super.selectOne(new EntityWrapper<MasterRoleDO>().where("code={0}", rCode));
  }

  /**
   * 查询所有角色信息.
   *
   * @return
   */
  //@Cacheable(value = "master", key = "#root.targetClass")
  @Override
  public List<MasterRoleDO> selectAll() {
    return super.selectList(new EntityWrapper<MasterRoleDO>().orderBy("create_time", false));
  }
}
