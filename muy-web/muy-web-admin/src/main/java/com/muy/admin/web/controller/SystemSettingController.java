package com.muy.admin.web.controller;

import com.muy.admin.model.domain.MasterGroupDO;
import com.muy.admin.model.query.CreateGroupQuery;
import com.muy.admin.model.query.UpdateGroupQuery;
import com.muy.admin.model.vo.LoadMasterGroupVO;
import com.muy.admin.service.SystemSettingService;
import com.muy.util.mapper.MapperUtil;
import com.muy.util.wrapper.WrapMapper;
import com.muy.util.wrapper.Wrapper;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.http.MediaType;
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

  @GetMapping(value = "/group/all/load")
  @ResponseBody
  public Wrapper loadAllGroup() {
    List<MasterGroupDO> result = systemSettingService.loadAll4Group();

    return WrapMapper.ok(MapperUtil.map(result, LoadMasterGroupVO.class));
  }

  @PostMapping(value = "/group/create")
  @ResponseBody
  public Wrapper createGroup(@RequestBody CreateGroupQuery query) {
    return WrapMapper.ok(systemSettingService.createMasterGroup(query));
  }

  @PostMapping(value = "/group/update")
  @ResponseBody
  public Wrapper updateGroup(@RequestBody UpdateGroupQuery query) {
    return WrapMapper.ok(systemSettingService.updateMasterGroup(query));
  }
}
