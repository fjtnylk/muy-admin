package com.muy.admin.web.controller;

import com.muy.admin.model.query.CreateUserQuery;
import com.muy.admin.service.UserService;
import com.muy.util.wrapper.WrapMapper;
import com.muy.util.wrapper.Wrapper;
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
@RequestMapping(value = "/admin", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {
  @Resource
  private UserService userService;

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
   * 加载用户信息.
   *
   * @param userId
   * @return
   */
  @GetMapping(value = "/user/{userId}")
  public Wrapper loadUser(@PathVariable("userId") Long userId) {
    return WrapMapper.ok(userService.loadUser(userId));
  }
}
