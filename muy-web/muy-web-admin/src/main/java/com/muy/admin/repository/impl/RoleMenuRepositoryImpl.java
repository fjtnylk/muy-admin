package com.muy.admin.repository.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muy.admin.mapper.RoleMenuMapper;
import com.muy.admin.model.domain.RoleMenuDO;
import com.muy.admin.repository.RoleMenuRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2018/5/24.
 */
@Repository
public class RoleMenuRepositoryImpl
    extends ServiceImpl<RoleMenuMapper, RoleMenuDO> implements RoleMenuRepository {

  /**
   * 保存/更新角色菜单信息.
   *
   * @param target
   * @return
   */
  @Override
  public boolean save(RoleMenuDO target) {
    return super.insertOrUpdate(target);
  }

  /**
   * 批量保存/更新角色菜单信息.
   *
   * @param target
   * @return
   */
  @Override
  public boolean save(List<RoleMenuDO> target) {
    return super.insertOrUpdateBatch(target);
  }

  /**
   * 删除指定角色菜单信息.
   *
   * @param rCode
   * @return
   */
  @Override
  public boolean delete(String rCode) {
    return
        super.delete(new EntityWrapper<RoleMenuDO>().where("r_code={0}", rCode));
  }

  /**
   * 查询指定角色菜单信息.
   *
   * @param rCode
   * @return
   */
  @Override
  public List<RoleMenuDO> selectByRoleCode(String rCode) {
    return
        super.selectList(new EntityWrapper<RoleMenuDO>().where("r_code={0}", rCode));
  }


  /**
   * 查询所有角色菜单信息.
   *
   * @return
   */
  @Override
  public List<RoleMenuDO> selectAll() {
    return
        super.selectList(new EntityWrapper<>());
  }
}
