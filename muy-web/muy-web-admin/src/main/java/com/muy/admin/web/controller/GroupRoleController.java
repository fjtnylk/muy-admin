package com.muy.admin.web.controller;

import com.muy.admin.model.domain.GroupRoleDO;
import com.muy.admin.model.domain.MasterRoleDO;
import com.muy.admin.model.query.SaveGroupRoleQuery;
import com.muy.admin.model.vo.LoadBindRoleVO;
import com.muy.admin.model.vo.TransferItemVO;
import com.muy.admin.service.GroupRoleService;
import com.muy.admin.service.SystemSettingService;
import com.muy.util.mapper.MapperUtil;
import com.muy.util.wrapper.WrapMapper;
import com.muy.util.wrapper.Wrapper;
import java.util.ArrayList;
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
 * Created by yanglikai on 2018/5/24.
 */
@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GroupRoleController {
  @Resource
  private GroupRoleService groupRoleService;
  @Resource
  private SystemSettingService systemSettingService;

  /**
   * 保存/更新组织角色信息.
   *
   * @param query
   * @return
   */
  @PostMapping(value = "/groups/role/save")
  @ResponseBody
  public Wrapper save(@Validated @RequestBody SaveGroupRoleQuery query) {
    return WrapMapper.ok(groupRoleService.save(query));
  }

  @GetMapping(value = "/groups/bind/role")
  @ResponseBody
  public Wrapper bindRole(String groupCode) {
    /* 加载所有角色 */
    List<MasterRoleDO> allRoles = systemSettingService.loadAll4Role();
    if (allRoles == null) {
      return WrapMapper.error("请先创建角色信息");
    }

    /* 加载目标组织下所属角色 */
    List<GroupRoleDO> groupRoles = groupRoleService.load(groupCode);

    LoadBindRoleVO result = new LoadBindRoleVO();
    result.setSource(MapperUtil.map(allRoles, TransferItemVO.class));
    result.setTargetKeys(
        groupRoles == null
            ? new ArrayList<>()
            : groupRoles.stream().map(el -> el.getRoleCode()).collect(Collectors.toList()));

    return WrapMapper.ok(result);
  }
}
