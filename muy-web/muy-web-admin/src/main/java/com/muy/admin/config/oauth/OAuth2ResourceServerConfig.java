package com.muy.admin.config.oauth;

import com.muy.security.core.authentication.password.PasswordAuthenticationSecurityConfig;
import com.muy.security.core.authorize.AuthorizeConfigManager;
import javax.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * Created by yanglikai on 2018/5/26.
 */
//@Configuration
//@EnableResourceServer
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {
  @Resource
  private PasswordAuthenticationSecurityConfig passwordAuthenticationSecurityConfig;
  @Resource
  private AccessDeniedHandler accessDeniedHandler;
  @Resource
  private AuthenticationEntryPoint authenticationEntryPoint;
  @Resource
  private AuthorizeConfigManager authorizeConfigManager;

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.apply(passwordAuthenticationSecurityConfig)
        .and()
        //.apply(smsAuthenticationSecurityConfig)
        //.and()
        //.authorizeRequests()
        //.antMatchers(SecurityConstant.DEFAULT_SIGN_IN_PROCESSING_URL_PASSWORD).permitAll()
        //.antMatchers("/admin/**").hasRole(SecurityConstant.ROLE_USER)
        //.anyRequest().authenticated()
        //.and()
        .headers().frameOptions().disable()
        .and()
        .exceptionHandling()
        .accessDeniedHandler(accessDeniedHandler)
        .authenticationEntryPoint(authenticationEntryPoint)
        .and()
        .csrf().disable()
        .anonymous().disable();

    authorizeConfigManager.config(http.authorizeRequests());
  }
}
