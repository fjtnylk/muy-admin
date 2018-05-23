package com.muy.admin.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.muy.admin.model.domain.MasterGroupDO;
import com.muy.admin.model.domain.MasterMenuDO;
import com.muy.admin.model.domain.MasterRoleDO;
import com.muy.admin.model.query.CreateGroupQuery;
import com.muy.admin.model.query.CreateMenuQuery;
import com.muy.admin.model.query.CreateRoleQuery;
import com.muy.admin.model.query.UpdateGroupQuery;
import com.muy.admin.model.query.UpdateMenuQuery;
import com.muy.admin.model.query.UpdateRoleQuery;
import com.muy.admin.repository.MasterGroupRepository;
import com.muy.admin.repository.MasterMenuRepository;
import com.muy.admin.repository.MasterRoleRepository;
import com.muy.util.mapper.MapperUtil;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 系统设置.
 * Created by yanglikai on 2018/5/22.
 */
@Service
public class SystemSettingService {
  @Resource
  private MasterGroupRepository groupRepository;
  @Resource
  private MasterRoleRepository roleRepository;
  @Resource
  private MasterMenuRepository menuRepository;

  // ============================================Group start=============================================

  /**
   * 创建组织.
   *
   * @param query
   * @return
   */
  public boolean create4Group(CreateGroupQuery query) {
    MasterGroupDO target = MapperUtil.map(query, MasterGroupDO.class);
    return groupRepository.insert(target);
  }

  /**
   * 更新组织.
   *
   * @param query
   * @return
   */
  public boolean update4Group(UpdateGroupQuery query) {
    MasterGroupDO entity = MapperUtil.map(query, MasterGroupDO.class);
    entity.setUpdateTime(new Date());

    Wrapper wrapper =
        new EntityWrapper()
            .where("code={0}", entity.getCode());

    return groupRepository.update(entity, wrapper);
  }

  /**
   * 加载所有组织信息.
   *
   * @return
   */
  public List<MasterGroupDO> loadAll4Group() {
    return groupRepository.selectAll();
  }

  // ============================================Group end  =============================================

  // ============================================Role start=============================================

  /**
   * 创建角色.
   *
   * @param query
   * @return
   */
  public boolean create4Role(CreateRoleQuery query) {
    MasterRoleDO target = MapperUtil.map(query, MasterRoleDO.class);
    return roleRepository.insert(target);
  }

  /**
   * 更新角色信息.
   *
   * @param query
   * @return
   */
  public boolean update4Role(UpdateRoleQuery query) {
    MasterRoleDO entity = MapperUtil.map(query, MasterRoleDO.class);
    entity.setUpdateTime(new Date());

    Wrapper wrapper = new EntityWrapper().where("code={0}", entity.getCode());

    return roleRepository.update(entity, wrapper);
  }

  /**
   * 加载所有角色信息.
   *
   * @return
   */
  public List<MasterRoleDO> loadAll4Role() {
    return roleRepository.selectAll();
  }
  // ============================================Role end  =============================================

  // ============================================Menu start=============================================

  /**
   * 创建菜单.
   *
   * @param query
   * @return
   */
  public boolean create4Menu(CreateMenuQuery query) {
    MasterMenuDO target = MapperUtil.map(query, MasterMenuDO.class);

    return menuRepository.insert(target);
  }

  /**
   * 更新菜单信息.
   *
   * @param query
   * @return
   */
  public boolean update4Menu(UpdateMenuQuery query) {
    MasterMenuDO entity = MapperUtil.map(query, MasterMenuDO.class);
    entity.setUpdateTime(new Date());

    Wrapper wrapper = new EntityWrapper().where("id={0}", entity.getId());

    return menuRepository.update(entity, wrapper);
  }

  /**
   * 加载所有菜单信息.
   *
   * @return
   */
  public List<MasterMenuDO> loadAll4Menu() {
    return menuRepository.selectAll();
  }
  // ============================================Menu end  =============================================
}
