package com.muy.admin.repository.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muy.admin.mapper.GroupRoleMapper;
import com.muy.admin.model.domain.GroupRoleDO;
import com.muy.admin.repository.GroupRoleRepository;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2018/5/24.
 */
@Repository
public class GroupRoleRepositoryImpl
    extends ServiceImpl<GroupRoleMapper, GroupRoleDO> implements GroupRoleRepository {
  @Resource
  private GroupRoleMapper groupRoleMapper;

  /**
   * 保存/更新组织角色信息.
   *
   * @param target
   * @return
   */
  @Override
  public boolean save(GroupRoleDO target) {
    return super.insertOrUpdate(target);
  }

  /**
   * 批量保存/更新组织角色信息.
   *
   * @param target
   * @return
   */
  @Override
  public boolean save(List<GroupRoleDO> target) {
    return super.insertOrUpdateBatch(target);
  }

  /**
   * 删除指定组织角色信息.
   *
   * @param gCode
   * @return
   */
  @Override
  public boolean delete(String gCode) {
    return
        super.delete(new EntityWrapper<GroupRoleDO>().where("g_code={0}", gCode));
  }

  /**
   * 查询指定组织角色信息.
   *
   * @param gCode
   * @return
   */
  @Override
  public List<GroupRoleDO> selectByGroupCode(String gCode) {
    return
        super.selectList(new EntityWrapper<GroupRoleDO>().where("g_code={0}", gCode));
  }

  /**
   * 查询所有组织角色信息.
   *
   * @return
   */
  @Override
  public List<GroupRoleDO> selectAll() {
    return
        super.selectList(new EntityWrapper<>());
  }
}
