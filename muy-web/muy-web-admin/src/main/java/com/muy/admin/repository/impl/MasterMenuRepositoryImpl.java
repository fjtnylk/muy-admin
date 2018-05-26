package com.muy.admin.repository.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muy.admin.mapper.MasterMenuMapper;
import com.muy.admin.model.domain.MasterMenuDO;
import com.muy.admin.repository.MasterMenuRepository;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2018/5/23.
 */
@Repository
public class MasterMenuRepositoryImpl
    extends ServiceImpl<MasterMenuMapper, MasterMenuDO> implements MasterMenuRepository {

  /**
   * 保存/更新菜单信息.
   *
   * @param target
   * @return
   */
  @Override
  public boolean save(MasterMenuDO target) {
    return super.insertOrUpdate(target);
  }

  /**
   * 批量保存/更新菜单信息.
   *
   * @param target
   * @return
   */
  @Override
  public boolean saveBatch(List<MasterMenuDO> target) {
    return super.insertOrUpdateBatch(target);
  }

  /**
   * 删除菜单信息.
   *
   * @param menuId
   * @return
   */
  @Override
  public boolean delete(Integer menuId) {
    return super.deleteById(menuId);
  }

  /**
   * 批量删除菜单信息.
   *
   * @param menuIdList
   * @return
   */
  @Override
  public boolean deleteBatch(List<Integer> menuIdList) {
    return super.deleteBatchIds(menuIdList);
  }

  /**
   * 加载单条菜单信息.
   *
   * @param menuId
   * @return
   */
  @Override
  public MasterMenuDO selectSignle(Integer menuId) {
    return
        super.selectOne(new EntityWrapper<MasterMenuDO>().where("id={0}", menuId));
  }

  /**
   * 加载所有菜单信息.
   *
   * @return
   */
  //@Cacheable(value = "master", key = "#root.targetClass")
  @Override
  public List<MasterMenuDO> selectAll() {
    return super.selectList(new EntityWrapper<>());
  }
}
