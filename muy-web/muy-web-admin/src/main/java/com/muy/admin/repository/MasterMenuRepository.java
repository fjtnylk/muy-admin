package com.muy.admin.repository;

import com.baomidou.mybatisplus.service.IService;
import com.muy.admin.model.domain.MasterMenuDO;
import java.util.List;

/**
 * Created by yanglikai on 2018/5/23.
 */
public interface MasterMenuRepository extends IService<MasterMenuDO> {

  /**
   * 保存/更新菜单信息.
   *
   * @param target
   * @return
   */
  boolean save(MasterMenuDO target);

  /**
   * 批量保存/更新菜单信息.
   *
   * @param target
   * @return
   */
  boolean saveBatch(List<MasterMenuDO> target);

  /**
   * 删除菜单信息.
   *
   * @param menuId
   * @return
   */
  boolean delete(Integer menuId);

  /**
   * 批量删除菜单信息.
   *
   * @param menuIdList
   * @return
   */
  boolean deleteBatch(List<Integer> menuIdList);

  /**
   * 加载单条菜单信息.
   *
   * @param menuId
   * @return
   */
  MasterMenuDO selectSignle(Integer menuId);

  /**
   * 加载所有菜单信息.
   *
   * @return
   */
  List<MasterMenuDO> selectAll();
}
