package com.muy.admin.repository;

import com.baomidou.mybatisplus.service.IService;
import com.muy.admin.model.domain.UserDO;

/**
 * Created by yanglikai on 2018/5/24.
 */
public interface UserRepository extends IService<UserDO> {

  /**
   * 保存/更新用户信息.
   *
   * @param target
   * @return
   */
  UserDO save(UserDO target);

  /**
   * 根据用户编号查询用户信息.
   *
   * @param userId
   * @return
   */
  UserDO selectByUid(Long userId);

  /**
   * 根据用户名称查询用户信息.
   *
   * @param userName
   * @return
   */
  UserDO selectByUsername(String userName);

  /**
   * 根据手机号查询用户信息.
   *
   * @param mobile
   * @return
   */
  UserDO selectByMobile(String mobile);
}
