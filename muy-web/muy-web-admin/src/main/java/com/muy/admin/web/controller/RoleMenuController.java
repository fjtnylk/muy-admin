package com.muy.admin.web.controller;

import com.muy.admin.model.query.DeleteRoleMenuQuery;
import com.muy.admin.model.query.SaveRoleMenuQuery;
import com.muy.admin.service.RoleMenuService;
import com.muy.util.wrapper.WrapMapper;
import com.muy.util.wrapper.Wrapper;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanglikai on 2018/5/24.
 */
@RestController
@RequestMapping(value = "/admin", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RoleMenuController {
  @Resource
  private RoleMenuService roleMenuService;

  /**
   * 保存/更新角色菜单信息.
   *
   * @param query
   * @return
   */
  @PostMapping(value = "/role/menu/save")
  @ResponseBody
  public Wrapper save(@Validated @RequestBody SaveRoleMenuQuery query) {
    return WrapMapper.ok(roleMenuService.save(query));
  }

  /**
   * 批量保存/更新角色菜单信息.
   *
   * @param query
   * @return
   */
  @PostMapping(value = "/role/menu/batch/save")
  @ResponseBody
  public Wrapper saveBatch(@Valid @RequestBody List<SaveRoleMenuQuery> query) {
    return WrapMapper.ok(roleMenuService.save(query));
  }

  /**
   * 删除角色菜单信息.
   *
   * @param query
   * @return
   */
  @PostMapping(value = "/role/menu/delete")
  @ResponseBody
  public Wrapper delete(@Validated @RequestBody DeleteRoleMenuQuery query) {
    return WrapMapper.ok(roleMenuService.delete(query));
  }

  /**
   * 加载指定角色下菜单信息.
   *
   * @param roleCode
   * @return
   */
  @GetMapping(value = "/role/{roleCode}/menu")
  @ResponseBody
  public Wrapper load(@PathVariable("roleCode") String roleCode) {
    return WrapMapper.ok(roleMenuService.load(roleCode));
  }

  /**
   * 加载所有角色菜单信息.
   *
   * @return
   */
  @GetMapping(value = "/role/menu/all")
  @ResponseBody
  public Wrapper loadAll() {
    return WrapMapper.ok(roleMenuService.loadAll());
  }
}
