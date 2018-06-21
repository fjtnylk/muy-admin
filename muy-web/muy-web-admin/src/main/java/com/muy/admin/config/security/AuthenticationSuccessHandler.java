package com.muy.admin.config.security;

import com.muy.admin.service.UserService;
import com.muy.security.core.SecurityUser;
import com.muy.util.json.JSONUtil;
import com.muy.util.wrapper.WrapMapper;
import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * Created by yanglikai on 2018/5/25.
 */
@Slf4j
@Component
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
  @Resource
  private UserService userService;

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                      Authentication authentication) throws IOException, ServletException {

    SecurityUser principal = (SecurityUser) authentication.getPrincipal();

    log.info("用户【 {} 】记录登录日志", principal.getUsername());

    /* 登录后处理 */
    userService.loginAfterProc(principal.getUserId());

    response.setContentType("application/json;charset=UTF-8");
    response.getWriter().write(JSONUtil.toJSON(WrapMapper.ok(principal)));
  }
}
