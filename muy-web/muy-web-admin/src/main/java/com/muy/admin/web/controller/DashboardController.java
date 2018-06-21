package com.muy.admin.web.controller;

import com.muy.admin.model.vo.UMCLoadDashboardVO;
import com.muy.util.wrapper.WrapMapper;
import com.muy.util.wrapper.Wrapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanglikai on 2018/6/21.
 */
@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DashboardController {

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
