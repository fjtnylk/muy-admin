package com.muy.security.core.authorize;

import com.muy.security.core.SecurityConstant;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * 核心模块的授权配置提供器，安全模块涉及的url的授权配置在这里。
 * <p>
 * Created by yanglikai on 2018/5/27.
 */
@Configuration
@Order(Integer.MIN_VALUE)
public class DefaultAuthorizeConfigProvider implements AuthorizeConfigProvider {

  @Override
  public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
    config.antMatchers(SecurityConstant.DEFAULT_SIGN_IN_PROCESSING_URL_PASSWORD,
        SecurityConstant.DEFAULT_SIGN_IN_PROCESSING_URL_MOBILE,
        "/druid/**", "/uac/auth/**", "/swagger-ui.html", "/swagger-resources/**", "/v2/api-docs").permitAll();

    return false;
  }
}
