package com.muy.admin.web.controller;

import com.muy.admin.service.CityService;
import com.muy.util.wrapper.WrapMapper;
import com.muy.util.wrapper.Wrapper;
import javax.annotation.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanglikai on 2018/6/14.
 */
@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CityController {
  @Resource
  private CityService cityService;

  /**
   * 加载城市级联.
   *
   * @return
   */
  @GetMapping(value = "/citys")
  @ResponseBody
  public Wrapper loadCascader() {
    return WrapMapper.ok(cityService.loadCascader());
  }
}
