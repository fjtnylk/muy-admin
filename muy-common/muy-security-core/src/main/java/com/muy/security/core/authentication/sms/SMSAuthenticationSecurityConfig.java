package com.muy.security.core.authentication.sms;

import javax.annotation.Resource;
import org.springframework.context.annotation.Configuration;
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
 * 短信登录配置.
 * <p>
 * Created by yanglikai on 2018/5/25.
 */
@Configuration
public class SMSAuthenticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
  @Resource
  private AuthenticationSuccessHandler authenticationSuccessHandler;
  @Resource
  private AuthenticationFailureHandler authenticationFailureHandler;
  @Resource
  private AuthenticationUserDetailsService userDetailsService;

  @Override
  public void configure(HttpSecurity http) {
    SMSAuthenticationFilter smsAuthenticationFilter = new SMSAuthenticationFilter();
    smsAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
    smsAuthenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
    smsAuthenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandler);

    SMSAuthenticationProvider smsAuthenticationProvider = new SMSAuthenticationProvider();
    smsAuthenticationProvider.setUserDetailsService(userDetailsService);

    http.authenticationProvider(smsAuthenticationProvider)
        .addFilterAfter(smsAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
  }
}
