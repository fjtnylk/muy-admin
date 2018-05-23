package com.muy.admin.repository.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muy.admin.mapper.MasterGroupMapper;
import com.muy.admin.model.domain.MasterGroupDO;
import com.muy.admin.repository.MasterGroupRepository;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2018/5/22.
 */
@Repository
public class MasterGroupRepositoryImpl
    extends ServiceImpl<MasterGroupMapper, MasterGroupDO>
    implements MasterGroupRepository {

  @Resource
  private MasterGroupMapper masterGroupMapper;

  /**
   * 查询所有组织信息.
   *
   * @return
   */
  @Cacheable(value = "group", key = "#root.methodName")
  @Override
  public List<MasterGroupDO> selectAllGroup() {
    return super.selectList(new EntityWrapper<MasterGroupDO>());
  }
}
