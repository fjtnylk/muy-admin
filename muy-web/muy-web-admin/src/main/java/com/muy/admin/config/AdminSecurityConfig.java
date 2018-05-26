package com.muy.admin.config;

import com.muy.security.core.authentication.password.PasswordAuthenticationSecurityConfig;
import com.muy.security.core.authentication.sms.SMSAuthenticationSecurityConfig;
import javax.annotation.Resource;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * Created by yanglikai on 2018/5/25.
 */
@Configuration
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {
  @Resource
  private PasswordAuthenticationSecurityConfig passwordAuthenticationSecurityConfig;
  @Resource
  private AccessDeniedHandler accessDeniedHandler;
  @Resource
  private AuthenticationEntryPoint authenticationEntryPoint;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    super.configure(auth);
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    super.configure(web);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
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
        .cors().configurationSource(buildCorsConfigSource())
        .and()
        .anonymous().disable();
  }

  private CorsConfigurationSource buildCorsConfigSource() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/admin/**", buildConfig());
    return source;
  }

  private CorsConfiguration buildConfig() {
    CorsConfiguration corsConfiguration = new CorsConfiguration();
    corsConfiguration.addAllowedOrigin("*");
    corsConfiguration.addAllowedHeader("*");
    corsConfiguration.addAllowedMethod("*");

    return corsConfiguration;
  }
}
