package com.muy.admin.repository.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muy.admin.mapper.UserRoleMapper;
import com.muy.admin.model.domain.UserRoleDO;
import com.muy.admin.repository.UserRoleRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2018/5/24.
 */
@Repository
public class UserRoleRepositoryImpl
    extends ServiceImpl<UserRoleMapper, UserRoleDO> implements UserRoleRepository {

  /**
   * 保存/更新用户角色信息.
   *
   * @param target
   * @return
   */
  @Override
  public boolean save(UserRoleDO target) {
    return super.insertOrUpdate(target);
  }

  /**
   * 删除用户角色信息.
   *
   * @param userId
   * @return
   */
  @Override
  public boolean delete(Long userId) {
    return
        super.delete(new EntityWrapper<UserRoleDO>().where("user_id={0}", userId));
  }

  /**
   * 查询用户角色信息.
   *
   * @param userId
   * @return
   */
  @Override
  public UserRoleDO select(Long userId) {
    return
        super.selectOne(new EntityWrapper<UserRoleDO>().where("user_id={0}", userId));
  }
}
