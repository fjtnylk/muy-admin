package com.muy.security.core;

import com.muy.security.core.authentication.AuthenticationBeanConfig;
import com.muy.security.core.authentication.password.PasswordAuthenticationSecurityConfig;
import com.muy.security.core.authentication.sms.SMSAuthenticationSecurityConfig;
import com.muy.security.core.properties.MuySecurityProperties;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 安全核心配置.
 * Created by yanglikai on 2018/5/25.
 */
@Configuration
@ImportAutoConfiguration({
    PasswordAuthenticationSecurityConfig.class,
    SMSAuthenticationSecurityConfig.class,
    AuthenticationBeanConfig.class,
    SpringSecurityConfig.class})
@EnableConfigurationProperties(MuySecurityProperties.class)
public class SecurityCoreConfig {
}
