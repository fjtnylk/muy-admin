package com.muy.admin.web.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.muy.admin.model.convert.PageConverter;
import com.muy.admin.model.domain.MasterRoleDO;
import com.muy.admin.model.query.DeleteRoleQuery;
import com.muy.admin.model.query.SaveRoleQuery;
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
 * Created by yanglikai on 2018/5/31.
 */
@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RoleController {
  @Resource
  private SystemSettingService systemSettingService;

  // ============================================Role start=============================================

  /**
   * 加载所有角色信息.
   *
   * @return
   */
  @GetMapping(value = "/roles")
  @ResponseBody
  public Wrapper loadAllRole(Integer page, Integer pageSize) {
    int current = page == null ? 1 : page;
    int size = pageSize == null ? 10 : pageSize;
    Page<MasterRoleDO> rolesPage = systemSettingService.loadPage4Role(current, size);

    PageConverter convert = new PageConverter(rolesPage);

    return WrapMapper.ok(convert.convert());
  }

  /**
   * 保存/更新角色信息.
   *
   * @param query
   * @return
   */
  @PostMapping(value = "/roles/save")
  @ResponseBody
  public Wrapper saveRole(@Validated @RequestBody SaveRoleQuery query) {
    return WrapMapper.ok(systemSettingService.save4Role(query));
  }

  /**
   * 删除角色信息.
   *
   * @param query
   * @return
   */
  @PostMapping(value = "/roles/delete")
  @ResponseBody
  public Wrapper deleteRole(@Validated @RequestBody DeleteRoleQuery query) {
    return WrapMapper.ok(systemSettingService.delete4Role(query.getCode()));
  }
  // ============================================Role end  =============================================
}
