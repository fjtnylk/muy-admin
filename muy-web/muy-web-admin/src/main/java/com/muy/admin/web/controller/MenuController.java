package com.muy.admin.web.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.muy.admin.model.convert.PageConverter;
import com.muy.admin.model.domain.MasterMenuDO;
import com.muy.admin.model.query.DeleteMenuQuery;
import com.muy.admin.model.query.SaveMenuQuery;
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
public class MenuController {
  @Resource
  private SystemSettingService systemSettingService;

  // ============================================Menu start=============================================

  /**
   * 加载所有菜单信息.
   *
   * @return
   */
  @GetMapping(value = "/menus")
  @ResponseBody
  public Wrapper loadMenus() {
    return WrapMapper.ok(systemSettingService.loadAll4Menu());
  }

  /**
   * 分页加载菜单信息.
   *
   * @return
   */
  @GetMapping(value = "/menus/page")
  @ResponseBody
  public Wrapper loadPage(Integer page, Integer pageSize) {
    int current = page == null ? 1 : page;
    int size = pageSize == null ? GlobalConstant.DEFAULT_PAGE_SIZE : pageSize;

    Page<MasterMenuDO> menuPage = systemSettingService.loadPage4Menu(current, size);

    PageConverter converter = new PageConverter(menuPage);

    return WrapMapper.ok(converter.convert());
  }

  /**
   * 保存/更新菜单.
   *
   * @param query
   * @return
   */
  @PostMapping(value = "/menus/save")
  @ResponseBody
  public Wrapper saveMenu(@Validated @RequestBody SaveMenuQuery query) {
    return WrapMapper.ok(systemSettingService.save4Menu(query));
  }

  /**
   * 删除菜单信息.
   *
   * @param query
   * @return
   */
  @PostMapping(value = "/menus/delete")
  @ResponseBody
  public Wrapper deleteMenu(@Validated @RequestBody DeleteMenuQuery query) {
    return WrapMapper.ok(systemSettingService.delete4Menu(query.getMenuId()));
  }
  // ============================================Menu end  =============================================
}
