package com.muy.admin.web.controller;

import com.muy.admin.model.domain.MasterMenuDO;
import com.muy.admin.model.domain.RoleMenuDO;
import com.muy.admin.model.query.SaveRoleMenuQuery;
import com.muy.admin.model.vo.LoadBindRoleVO;
import com.muy.admin.model.vo.TransferItemVO;
import com.muy.admin.service.RoleMenuService;
import com.muy.admin.service.SystemSettingService;
import com.muy.util.mapper.MapperUtil;
import com.muy.util.wrapper.WrapMapper;
import com.muy.util.wrapper.Wrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanglikai on 2018/5/24.
 */
@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RoleMenuController {
  @Resource
  private RoleMenuService roleMenuService;
  @Resource
  private SystemSettingService systemSettingService;

  /**
   * 保存/更新角色菜单信息.
   *
   * @param query
   * @return
   */
  @PostMapping(value = "/roles/menu/save")
  @ResponseBody
  public Wrapper save(@Validated @RequestBody SaveRoleMenuQuery query) {
    return WrapMapper.ok(roleMenuService.save(query));
  }

  /**
   * 角色、菜单绑定信息.
   *
   * @param roleCode
   * @return
   */
  @GetMapping(value = "/roles/bind/menu")
  @ResponseBody
  public Wrapper loadBindRoleMenus(String roleCode) {
    /* 加载所有菜单 */
    List<MasterMenuDO> allMenus =
        systemSettingService.loadAll4Menu()
            .stream()
            .filter(el -> StringUtils.isNotBlank(el.getRoute())).collect(Collectors.toList());
    if (allMenus == null) {
      return WrapMapper.error("请先创建菜单信息");
    }

    /* 加载目标角色下绑定菜单 */
    List<RoleMenuDO> roleMenus = roleMenuService.load(roleCode);

    LoadBindRoleVO result = new LoadBindRoleVO();
    result.setSource(MapperUtil.map(allMenus, TransferItemVO.class));
    result.setTargetKeys(
        roleMenus == null
            ? new ArrayList<>()
            : roleMenus.stream().map(el -> String.valueOf(el.getMenuId())).collect(Collectors.toList()));

    return WrapMapper.ok(result);
  }
}
