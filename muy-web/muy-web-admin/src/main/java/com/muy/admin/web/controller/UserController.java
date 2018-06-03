package com.muy.admin.web.controller;

import com.muy.admin.model.query.CreateUserQuery;
import com.muy.admin.model.query.LoginUserQuery;
import com.muy.admin.model.vo.LoadGroupsVO;
import com.muy.admin.model.vo.UMCLoadDashboardVO;
import com.muy.admin.service.SystemSettingService;
import com.muy.admin.service.UserService;
import com.muy.util.wrapper.WrapMapper;
import com.muy.util.wrapper.Wrapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
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
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {
  @Resource
  private UserService userService;
  @Resource
  private SystemSettingService systemSettingService;

  /**
   * 创建用户.
   *
   * @param query
   * @return
   */
  @PostMapping(value = "/user/create")
  @ResponseBody
  public Wrapper createUser(@Validated @RequestBody CreateUserQuery query) {
    return WrapMapper.ok(userService.createUser(query));
  }

  /**
   * 用户登录.
   *
   * @param query
   * @return
   */
  @PostMapping(value = "/user/login")
  @ResponseBody
  public Wrapper login(@RequestBody LoginUserQuery query) {
    return WrapMapper.ok(userService.authUser(query.getUsername(), query.getPassword()));
  }

  /**
   * 退出.
   *
   * @return
   */
  @GetMapping(value = "/user/logout")
  @ResponseBody
  public Wrapper logout(String key) {
    return WrapMapper.ok();
  }

  /**
   * 加载用户信息.
   *
   * @param userId
   * @return
   */
  @GetMapping(value = "/user/{userId}")
  @ResponseBody
  public Wrapper loadUser(@PathVariable("userId") Long userId) {
    return WrapMapper.ok(userService.loadUser(userId));
  }

  @GetMapping(value = "/user")
  @ResponseBody
  public Wrapper loadUser4No() {
    return WrapMapper.ok(userService.loadUser(1000000000L));
  }

  /**
   * 加载看板信息.
   *
   * @return
   */
  @GetMapping(value = "/dashboard")
  @ResponseBody
  public Wrapper loadDashboard() {
    UMCLoadDashboardVO result = UMCLoadDashboardVO.builder().build();
    result.init();
    return WrapMapper.ok(result);
  }
}
