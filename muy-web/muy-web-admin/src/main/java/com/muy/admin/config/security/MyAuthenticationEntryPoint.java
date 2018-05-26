package com.muy.admin.config.security;

import com.muy.base.enums.ErrorCodeEnum;
import com.muy.util.json.JSONUtil;
import com.muy.util.wrapper.WrapMapper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * Created by yanglikai on 2018/5/25.
 */
@Slf4j
@Configuration
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {
  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
      throws IOException, ServletException {
    log.info("处理权限异常. e={}", e);

    response.setStatus(HttpStatus.UNAUTHORIZED.value());
    response.setContentType("application/json;charset=UTF-8");
    response.getWriter().write(JSONUtil.toJSON(WrapMapper.error(ErrorCodeEnum.GL99990401)));
  }

  public static boolean isAjax(HttpServletRequest request) {
    String header = request.getHeader("X-Requested-With");
    return header != null && "XMLHttpRequest".equals(header);
  }
}
