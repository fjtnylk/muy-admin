package com.muy.security.core.authentication;

import com.muy.security.core.authentication.password.PasswordAuthenticationSecurityConfig;
import com.muy.security.core.authentication.sms.SMSAuthenticationSecurityConfig;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;

/**
 * 认证核心配置.
 * Created by yanglikai on 2018/5/25.
 */
@Configuration
@ImportAutoConfiguration({PasswordAuthenticationSecurityConfig.class, SMSAuthenticationSecurityConfig.class})
public class AuthenticationCoreConfig {

  @Bean
  @ConditionalOnMissingBean(AuthenticationUserDetailsService.class)
  public AuthenticationUserDetailsService userDetailsService() {
    return new DefaultUserDetailsService();
  }
}
