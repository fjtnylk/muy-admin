package com.muy.admin.repository.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muy.admin.mapper.MasterGroupMapper;
import com.muy.admin.model.domain.MasterGroupDO;
import com.muy.admin.repository.MasterGroupRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2018/5/22.
 */
@Repository
public class MasterGroupRepositoryImpl
    extends ServiceImpl<MasterGroupMapper, MasterGroupDO> implements MasterGroupRepository {

  /**
   * 保存/更新组织信息.
   *
   * @param target
   * @return
   */
  //@CachePut(value = "group", key = "#p0.code")
  @Override
  public boolean save(MasterGroupDO target) {
    return super.insertOrUpdate(target);
  }

  /**
   * 批量保存/更新组织信息.
   *
   * @param target
   * @return
   */
  @Override
  public boolean saveBatch(List<MasterGroupDO> target) {
    return super.insertOrUpdateBatch(target);
  }

  /**
   * 删除组织.
   *
   * @param gCode
   * @return
   */
  //@CacheEvict(value = "group", key = "#p0")
  @Override
  public boolean delete(String gCode) {
    return super.deleteById(gCode);
  }

  /**
   * 批量删除组织.
   *
   * @param gCodeList
   * @return
   */
  @Override
  public boolean deleteBatch(List<String> gCodeList) {
    return super.deleteBatchIds(gCodeList);
  }

  /**
   * 查询组织信息.
   *
   * @param gCode
   * @return
   */
  //@Cacheable(value = "group", key = "#p0")
  @Override
  public MasterGroupDO selectSignle(String gCode) {
    return
        super.selectOne(new EntityWrapper<MasterGroupDO>().where("code={0}", gCode));
  }

  /**
   * 查询所有组织信息.
   *
   * @return
   */
  //@Cacheable(value = "group", key = "#root.targetClass")
  @Override
  public List<MasterGroupDO> selectAll() {
    return super.selectList(new EntityWrapper<>());
  }
}
