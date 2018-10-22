package com.muy.admin.web.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.muy.admin.model.domain.UserDO;
import com.muy.admin.model.query.CreateUserQuery;
import com.muy.admin.model.query.DeleteUserQuery;
import com.muy.admin.model.query.LoadPageQuery;
import com.muy.admin.model.query.LoginUserQuery;
import com.muy.admin.model.query.SaveUserQuery;
import com.muy.admin.model.wrapper.PageWrapper;
import com.muy.admin.service.UserService;
import com.muy.util.wrapper.WrapMapper;
import com.muy.util.wrapper.Wrapper;
import javax.annotation.Resource;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
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
public class UserController {
  @Resource
  private UserService userService;

  /**
   * 分页加载用户信息.
   *
   * @param query
   * @return
   */
  @GetMapping(value = "/users")
  @ResponseBody
  public Wrapper loadPage(LoadPageQuery query) {
    Page<UserDO> page = userService.loadPage(query);

    return
        WrapMapper.ok(
            PageWrapper.wrap(page));
  }

  /**
   * 保存/更新用户.
   *
   * @param query
   * @return
   */
  @PostMapping(value = "/users/save")
  @ResponseBody
  public Wrapper saveUser(@Validated @RequestBody SaveUserQuery query) {
    return WrapMapper.ok(userService.saveUser(query));
  }

  /**
   * 删除用户.
   *
   * @param query
   * @return
   */
  @PostMapping(value = "/users/delete")
  @ResponseBody
  public Wrapper deleteGroup(@Validated @RequestBody DeleteUserQuery query) {
    return WrapMapper.ok(userService.deleteUser(query));
  }

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
  @GetMapping(value = "/user")
  @ResponseBody
  public Wrapper loadUser(Long userId) {
    if (userId == null) {
      return WrapMapper.error();
    }

    return WrapMapper.ok(userService.loadUser(userId));
  }
}
