package com.muy.admin.repository.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muy.admin.mapper.MasterMenuMapper;
import com.muy.admin.model.domain.MasterMenuDO;
import com.muy.admin.repository.MasterMenuRepository;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2018/5/23.
 */
@Repository
public class MasterMenuRepositoryImpl
    extends ServiceImpl<MasterMenuMapper, MasterMenuDO> implements MasterMenuRepository {
  @Resource
  private MasterMenuMapper menuMapper;

  /**
   * 加载所有菜单信息.
   *
   * @return
   */
  @Cacheable(value = "master", key = "#root.targetClass")
  @Override
  public List<MasterMenuDO> selectAll() {
    return super.selectList(new EntityWrapper<>());
  }
}
