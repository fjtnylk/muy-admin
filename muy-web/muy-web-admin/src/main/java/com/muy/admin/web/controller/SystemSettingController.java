package com.muy.admin.web.controller;

import com.muy.admin.model.query.CreateGroupQuery;
import com.muy.admin.model.query.CreateMenuQuery;
import com.muy.admin.model.query.CreateRoleQuery;
import com.muy.admin.model.query.UpdateGroupQuery;
import com.muy.admin.model.query.UpdateMenuQuery;
import com.muy.admin.model.query.UpdateRoleQuery;
import com.muy.admin.service.SystemSettingService;
import com.muy.util.wrapper.WrapMapper;
import com.muy.util.wrapper.Wrapper;
import javax.annotation.Resource;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanglikai on 2018/5/22.
 */
@RestController
@RequestMapping(value = "/admin", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SystemSettingController {
  @Resource
  private SystemSettingService systemSettingService;

  // ============================================Group start=============================================

  /**
   * 加载所有组织信息.
   *
   * @return
   */
  @GetMapping(value = "/group/all/load")
  @ResponseBody
  public Wrapper loadAllGroup() {
    return WrapMapper.ok(systemSettingService.loadAll4Group());
  }

  /**
   * 创建组织.
   *
   * @param query
   * @return
   */
  @PostMapping(value = "/group/create")
  @ResponseBody
  public Wrapper createGroup(@Validated @RequestBody CreateGroupQuery query) {
    return WrapMapper.ok(systemSettingService.create4Group(query));
  }

  /**
   * 更新组织.
   *
   * @param query
   * @return
   */
  @PostMapping(value = "/group/update")
  @ResponseBody
  public Wrapper updateGroup(@Validated @RequestBody UpdateGroupQuery query) {
    return WrapMapper.ok(systemSettingService.update4Group(query));
  }
  // ============================================Group end  =============================================

  // ============================================Role start=============================================

  /**
   * 加载所有角色信息.
   *
   * @return
   */
  @GetMapping(value = "/role/all/load")
  @ResponseBody
  public Wrapper loadAllRole() {
    return WrapMapper.ok(systemSettingService.loadAll4Role());
  }

  /**
   * 创建组织.
   *
   * @param query
   * @return
   */
  @PostMapping(value = "/role/create")
  @ResponseBody
  public Wrapper createRole(@Validated @RequestBody CreateRoleQuery query) {
    return WrapMapper.ok(systemSettingService.create4Role(query));
  }

  /**
   * 更新组织.
   *
   * @param query
   * @return
   */
  @PostMapping(value = "/role/update")
  @ResponseBody
  public Wrapper updateRole(@Validated @RequestBody UpdateRoleQuery query) {
    return WrapMapper.ok(systemSettingService.update4Role(query));
  }
  // ============================================Role end  =============================================

  // ============================================Menu start=============================================

  /**
   * 加载所有菜单信息.
   *
   * @return
   */
  @GetMapping(value = "/menu/all/load")
  @ResponseBody
  public Wrapper loadAllMenu() {
    return WrapMapper.ok(systemSettingService.loadAll4Menu());
  }

  /**
   * 创建菜单.
   *
   * @param query
   * @return
   */
  @PostMapping(value = "/menu/create")
  @ResponseBody
  public Wrapper createMenu(@Validated @RequestBody CreateMenuQuery query) {
    return WrapMapper.ok(systemSettingService.create4Menu(query));
  }

  /**
   * 更新菜单.
   *
   * @param query
   * @return
   */
  @PostMapping(value = "/menu/update")
  @ResponseBody
  public Wrapper updateMenu(@Validated @RequestBody UpdateMenuQuery query) {
    return WrapMapper.ok(systemSettingService.update4Menu(query));
  }
  // ============================================Menu end  =============================================
}
