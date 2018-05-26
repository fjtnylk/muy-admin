package com.muy.security.core.authentication;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;

/**
 * Created by yanglikai on 2018/5/25.
 */
@Configuration
public class AuthenticationBeanConfig {

  @Bean
  @ConditionalOnMissingBean(AuthenticationUserDetailsService.class)
  public AuthenticationUserDetailsService userDetailsService() {
    return new DefaultUserDetailsService();
  }
}
