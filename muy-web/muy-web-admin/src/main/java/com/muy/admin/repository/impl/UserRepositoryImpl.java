package com.muy.admin.repository.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muy.admin.mapper.UserMapper;
import com.muy.admin.model.domain.UserDO;
import com.muy.admin.repository.UserRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2018/5/24.
 */
@Repository
public class UserRepositoryImpl
    extends ServiceImpl<UserMapper, UserDO> implements UserRepository {
  /**
   * 保存/更新用户信息.
   *
   * @param target
   * @return
   */
  @Override
  public UserDO save(UserDO target) {
    super.insertOrUpdate(target);
    return target;
  }

  /**
   * 根据用户编号查询用户信息.
   *
   * @param userId
   * @return
   */
  @Override
  public UserDO selectByUid(Long userId) {
    return
        super.selectOne(new EntityWrapper<UserDO>().where("id={0}", userId));
  }

  /**
   * 根据用户名称查询用户信息.
   *
   * @param userName
   * @return
   */
  @Override
  public UserDO selectByUsername(String userName) {
    return
        super.selectOne(new EntityWrapper<UserDO>().where("user_name={0}", userName));
  }

  /**
   * 根据手机号查询用户信息.
   *
   * @param mobile
   * @return
   */
  @Override
  public UserDO selectByMobile(String mobile) {
    return
        super.selectOne(new EntityWrapper<UserDO>().where("mobile={0}", mobile));
  }
}
