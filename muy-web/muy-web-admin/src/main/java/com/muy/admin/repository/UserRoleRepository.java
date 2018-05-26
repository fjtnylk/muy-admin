package com.muy.admin.repository;

import com.baomidou.mybatisplus.service.IService;
import com.muy.admin.model.domain.UserRoleDO;

/**
 * Created by yanglikai on 2018/5/24.
 */
public interface UserRoleRepository extends IService<UserRoleDO> {

  /**
   * 保存/更新用户角色信息.
   *
   * @param target
   * @return
   */
  boolean save(UserRoleDO target);

  /**
   * 删除用户角色信息.
   *
   * @param userId
   * @return
   */
  boolean delete(Long userId);

  /**
   * 查询用户角色信息.
   *
   * @param userId
   * @return
   */
  UserRoleDO select(Long userId);
}
