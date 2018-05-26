package com.muy.admin.repository.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muy.admin.mapper.UserGroupMapper;
import com.muy.admin.model.domain.UserGroupDO;
import com.muy.admin.repository.UserGroupRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2018/5/24.
 */
@Repository
public class UserGroupRepositoryImpl
    extends ServiceImpl<UserGroupMapper, UserGroupDO> implements UserGroupRepository {
  /**
   * 保存/更新用户组织信息.
   *
   * @param target
   * @return
   */
  @Override
  public boolean save(UserGroupDO target) {
    return super.insertOrUpdate(target);
  }

  /**
   * 删除用户组织信息.
   *
   * @param userId
   * @return
   */
  @Override
  public boolean delete(Long userId) {
    return
        super.delete(new EntityWrapper<UserGroupDO>().where("user_id={0}", userId));
  }

  /**
   * 查询用户组织信息.
   *
   * @param userId
   * @return
   */
  @Override
  public UserGroupDO select(Long userId) {
    return
        super.selectOne(new EntityWrapper<UserGroupDO>().where("user_id={0}", userId));
  }
}
