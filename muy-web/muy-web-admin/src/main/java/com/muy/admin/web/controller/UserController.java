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
   * 加载菜单信息.
   *
   * @return
   */
  @GetMapping(value = "/menus")
  @ResponseBody
  public Wrapper loadMenus() {
    return WrapMapper.ok(systemSettingService.loadAll4Menu());
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

  @GetMapping(value = "/groups")
  @ResponseBody
  public Wrapper loadUsers(String userId) {
    List<LoadGroupsVO.GroupVO> data = new ArrayList<>();
    LoadGroupsVO.GroupVO d1 =
        LoadGroupsVO.GroupVO.builder().id(1).name("杨").age(23).address("成都").build();
    LoadGroupsVO.GroupVO d2 =
        LoadGroupsVO.GroupVO.builder().id(2).name("王").age(25).address("上海").build();
    LoadGroupsVO.GroupVO d3 =
        LoadGroupsVO.GroupVO.builder().id(3).name("黄").age(26).address("北京").build();
    LoadGroupsVO.GroupVO d4 =
        LoadGroupsVO.GroupVO.builder().id(4).name("黄").age(26).address("北京").build();
    LoadGroupsVO.GroupVO d5 =
        LoadGroupsVO.GroupVO.builder().id(5).name("黄").age(26).address("北京").build();
    LoadGroupsVO.GroupVO d6 =
        LoadGroupsVO.GroupVO.builder().id(6).name("黄").age(26).address("北京").build();
    LoadGroupsVO.GroupVO d7 =
        LoadGroupsVO.GroupVO.builder().id(7).name("黄").age(26).address("北京").build();
    LoadGroupsVO.GroupVO d8 =
        LoadGroupsVO.GroupVO.builder().id(8).name("黄").age(26).address("北京").build();
    LoadGroupsVO.GroupVO d9 =
        LoadGroupsVO.GroupVO.builder().id(9).name("黄").age(26).address("北京").build();
    LoadGroupsVO.GroupVO d10 =
        LoadGroupsVO.GroupVO.builder().id(10).name("黄").age(26).address("北京").build();
    LoadGroupsVO.GroupVO d11 =
        LoadGroupsVO.GroupVO.builder().id(11).name("黄").age(26).address("北京").build();
    LoadGroupsVO.GroupVO d12 =
        LoadGroupsVO.GroupVO.builder().id(12).name("黄").age(26).address("北京").build();
    LoadGroupsVO.GroupVO d13 =
        LoadGroupsVO.GroupVO.builder().id(13).name("黄").age(26).address("北京").build();

    data.add(d1);
    data.add(d2);
    data.add(d3);
    data.add(d4);
    data.add(d5);
    data.add(d6);
    data.add(d7);
    data.add(d8);
    data.add(d9);
    data.add(d10);
    data.add(d11);
    data.add(d12);
    data.add(d13);

    LoadGroupsVO groups = LoadGroupsVO.builder().build();
    groups.setTotal(13);
    groups.setCurrent(1);
    groups.setList(data);
    return WrapMapper.ok(groups);
  }
}
