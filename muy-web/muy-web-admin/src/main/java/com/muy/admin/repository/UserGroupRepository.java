package com.muy.admin.repository;

import com.baomidou.mybatisplus.service.IService;
import com.muy.admin.model.domain.UserGroupDO;

/**
 * Created by yanglikai on 2018/5/24.
 */
public interface UserGroupRepository extends IService<UserGroupDO> {
  /**
   * 保存/更新用户组织信息.
   *
   * @param target
   * @return
   */
  boolean save(UserGroupDO target);

  /**
   * 删除用户组织信息.
   *
   * @param userId
   * @return
   */
  boolean delete(Long userId);

  /**
   * 查询用户组织信息.
   *
   * @param userId
   * @return
   */
  UserGroupDO select(Long userId);
}
