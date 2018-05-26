package com.muy.security.core.authentication.password;

import javax.annotation.Resource;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * 用户名/密码登录配置.
 * Created by yanglikai on 2018/5/25.
 */
@Configuration
public class PasswordAuthenticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
  @Resource
  private AuthenticationSuccessHandler authenticationSuccessHandler;
  @Resource
  private AuthenticationFailureHandler authenticationFailureHandler;
  @Resource
  private AuthenticationUserDetailsService userDetailsService;

  @Override
  public void configure(HttpSecurity http) {
    PasswordAuthenticationFilter passwordAuthenticationFilter = new PasswordAuthenticationFilter();
    passwordAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
    passwordAuthenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
    passwordAuthenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandler);

    PasswordAuthenticationProvider passwordAuthenticationProvider = new PasswordAuthenticationProvider();
    passwordAuthenticationProvider.setUserDetailsService(userDetailsService);

    http.authenticationProvider(passwordAuthenticationProvider)
        .addFilterAfter(passwordAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
  }
}
