package com.muy.admin.repository.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muy.admin.mapper.RoleMenuMapper;
import com.muy.admin.model.domain.RoleMenuDO;
import com.muy.admin.repository.RoleMenuRepository;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2018/5/24.
 */
@Repository
public class RoleMenuRepositoryImpl
    extends ServiceImpl<RoleMenuMapper, RoleMenuDO> implements RoleMenuRepository {
  @Resource
  private RoleMenuMapper roleMenuMapper;
}
