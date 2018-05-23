package com.muy.admin.repository.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muy.admin.mapper.MasterRoleMapper;
import com.muy.admin.model.domain.MasterRoleDO;
import com.muy.admin.repository.MasterRoleRepository;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2018/5/23.
 */
@Repository
public class MasterRoleRepositoryImpl
    extends ServiceImpl<MasterRoleMapper, MasterRoleDO> implements MasterRoleRepository {
  @Resource
  private MasterRoleMapper roleMapper;

  /**
   * 查询所有角色信息.
   *
   * @return
   */
  @Cacheable(value = "master", key = "#root.targetClass")
  @Override
  public List<MasterRoleDO> selectAll() {
    return super.selectList(new EntityWrapper<>());
  }
}
