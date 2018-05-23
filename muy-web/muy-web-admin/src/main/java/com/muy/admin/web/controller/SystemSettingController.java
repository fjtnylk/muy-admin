package com.muy.admin.web.controller;

import com.muy.admin.model.query.DeleteGroupQuery;
import com.muy.admin.model.query.DeleteMenuQuery;
import com.muy.admin.model.query.DeleteRoleQuery;
import com.muy.admin.model.query.SaveGroupQuery;
import com.muy.admin.model.query.SaveMenuQuery;
import com.muy.admin.model.query.SaveRoleQuery;
import com.muy.admin.service.SystemSettingService;
import com.muy.util.wrapper.WrapMapper;
import com.muy.util.wrapper.Wrapper;
import java.util.List;
import java.util.stream.Collectors;
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
   * 加载单条组织信息.
   *
   * @param groupCode
   * @return
   */
  @GetMapping(value = "/group/signle/load")
  @ResponseBody
  public Wrapper loadSignleGroup(String groupCode) {
    return WrapMapper.ok(systemSettingService.loadSignle4Group(groupCode));
  }

  /**
   * 保存/更新组织信息.
   *
   * @param query
   * @return
   */
  @PostMapping(value = "/group/save")
  @ResponseBody
  public Wrapper saveGroup(@Validated @RequestBody SaveGroupQuery query) {
    return WrapMapper.ok(systemSettingService.save4Group(query));
  }

  /**
   * 批量保存/更新组织信息.
   *
   * @param query
   * @return
   */
  @PostMapping(value = "/group/batch/save")
  @ResponseBody
  public Wrapper saveBatchGroup(@Validated @RequestBody List<SaveGroupQuery> query) {
    return WrapMapper.ok(systemSettingService.saveBatch4Group(query));
  }

  /**
   * 删除组织信息.
   *
   * @param query
   * @return
   */
  @PostMapping(value = "/group/delete")
  @ResponseBody
  public Wrapper deleteGroup(@Validated @RequestBody DeleteGroupQuery query) {
    return WrapMapper.ok(systemSettingService.delete4Group(query.getCode()));
  }

  /**
   * 批量删除组织信息.
   *
   * @param query
   * @return
   */
  @PostMapping(value = "/group/batch/delete")
  @ResponseBody
  public Wrapper deleteBatchGroup(@Validated @RequestBody List<DeleteGroupQuery> query) {
    List<String> groupCdoeList =
        query.stream()
            .map(el -> el.getCode())
            .collect(Collectors.toList());

    return WrapMapper.ok(systemSettingService.deleteBatch4Group(groupCdoeList));
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
   * 加载单条角色信息.
   *
   * @param roleCode
   * @return
   */
  @GetMapping(value = "/role/signle/load")
  @ResponseBody
  public Wrapper loadSignleRole(String roleCode) {
    return WrapMapper.ok(systemSettingService.loadSignle4Role(roleCode));
  }

  /**
   * 保存/更新角色信息.
   *
   * @param query
   * @return
   */
  @PostMapping(value = "/role/save")
  @ResponseBody
  public Wrapper saveRole(@Validated @RequestBody SaveRoleQuery query) {
    return WrapMapper.ok(systemSettingService.save4Role(query));
  }

  /**
   * 批量保存/更新角色信息.
   *
   * @param query
   * @return
   */
  @PostMapping(value = "/role/batch/save")
  @ResponseBody
  public Wrapper saveBatchRole(@Validated @RequestBody List<SaveRoleQuery> query) {
    return WrapMapper.ok(systemSettingService.saveBatch4Role(query));
  }

  /**
   * 删除角色信息.
   *
   * @param query
   * @return
   */
  @PostMapping(value = "/role/delete")
  @ResponseBody
  public Wrapper deleteRole(@Validated @RequestBody DeleteRoleQuery query) {
    return WrapMapper.ok(systemSettingService.delete4Role(query.getCode()));
  }

  /**
   * 批量删除角色信息.
   *
   * @param query
   * @return
   */
  @PostMapping(value = "/role/batch/delete")
  @ResponseBody
  public Wrapper deleteBatchRole(@Validated @RequestBody List<DeleteRoleQuery> query) {
    List<String> roleCodeList =
        query.stream()
            .map(el -> el.getCode())
            .collect(Collectors.toList());

    return WrapMapper.ok(systemSettingService.deleteBatch4Role(roleCodeList));
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
   * 加载单条菜单信息.
   *
   * @param menuId
   * @return
   */
  @GetMapping(value = "/menu/signle/load")
  @ResponseBody
  public Wrapper loadSignleMenu(Integer menuId) {
    return WrapMapper.ok(systemSettingService.loadSignle4Menu(menuId));
  }

  /**
   * 保存/更新菜单.
   *
   * @param query
   * @return
   */
  @PostMapping(value = "/menu/save")
  @ResponseBody
  public Wrapper saveMenu(@Validated @RequestBody SaveMenuQuery query) {
    return WrapMapper.ok(systemSettingService.save4Menu(query));
  }

  /**
   * 批量保存/更新菜单.
   *
   * @param query
   * @return
   */
  @PostMapping(value = "/menu/batch/save")
  @ResponseBody
  public Wrapper saveBatchMenu(@Validated @RequestBody List<SaveMenuQuery> query) {
    return WrapMapper.ok(systemSettingService.saveBatch4Menu(query));
  }

  /**
   * 删除菜单信息.
   *
   * @param query
   * @return
   */
  @PostMapping(value = "/menu/delete")
  @ResponseBody
  public Wrapper deleteMenu(@Validated @RequestBody DeleteMenuQuery query) {
    return WrapMapper.ok(systemSettingService.delete4Menu(query.getMenuId()));
  }

  /**
   * 批量删除菜单信息.
   *
   * @param query
   * @return
   */
  @PostMapping(value = "/menu/batch/delete")
  @ResponseBody
  public Wrapper deleteBatchMenu(@Validated @RequestBody List<DeleteMenuQuery> query) {
    List<Integer> menuIdList =
        query.stream()
            .map(el -> el.getMenuId())
            .collect(Collectors.toList());

    return WrapMapper.ok(systemSettingService.deleteBatch4Menu(menuIdList));
  }
  // ============================================Menu end  =============================================
}
