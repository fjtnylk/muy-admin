package com.muy.admin.web.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.muy.admin.model.domain.MasterGroupDO;
import com.muy.admin.model.query.DeleteGroupQuery;
import com.muy.admin.model.query.SaveGroupQuery;
import com.muy.admin.model.wrapper.PageWrapper;
import com.muy.admin.service.SystemSettingService;
import com.muy.base.constant.GlobalConstant;
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
 * Created by yanglikai on 2018/6/1.
 */
@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GroupController {
  @Resource
  private SystemSettingService systemSettingService;

  // ============================================Group start=============================================

  /**
   * 分页加载组织信息.
   *
   * @return
   */
  @GetMapping(value = "/groups")
  @ResponseBody
  public Wrapper loadPage(Integer page, Integer pageSize) {
    int current = page == null ? 1 : page;
    int size = pageSize == null ? GlobalConstant.DEFAULT_PAGE_SIZE : pageSize;
    Page<MasterGroupDO> groupPage = systemSettingService.loadPage4Group(current, size);

    return
        WrapMapper.ok(
            PageWrapper.wrap(groupPage));
  }

  /**
   * 保存/更新组织信息.
   *
   * @param query
   * @return
   */
  @PostMapping(value = "/groups/save")
  @ResponseBody
  public Wrapper saveGroup(@Validated @RequestBody SaveGroupQuery query) {
    return WrapMapper.ok(systemSettingService.save4Group(query));
  }

  /**
   * 删除组织信息.
   *
   * @param query
   * @return
   */
  @PostMapping(value = "/groups/delete")
  @ResponseBody
  public Wrapper deleteGroup(@Validated @RequestBody DeleteGroupQuery query) {
    return WrapMapper.ok(systemSettingService.delete4Group(query.getCode()));
  }
  // ============================================Group end  =============================================
}
