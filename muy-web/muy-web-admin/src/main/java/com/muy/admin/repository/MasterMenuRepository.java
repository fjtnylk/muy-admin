package com.muy.admin.repository;

import com.baomidou.mybatisplus.service.IService;
import com.muy.admin.model.domain.MasterMenuDO;
import java.util.List;

/**
 * Created by yanglikai on 2018/5/23.
 */
public interface MasterMenuRepository extends IService<MasterMenuDO> {

  /**
   * 加载所有菜单信息.
   *
   * @return
   */
  List<MasterMenuDO> selectAll();
}
