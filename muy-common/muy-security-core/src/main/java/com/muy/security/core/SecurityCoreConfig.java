package com.muy.security.core;

import com.muy.security.core.authentication.AuthenticationCoreConfig;
import com.muy.security.core.properties.MySecurityProperties;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 安全核心配置.
 * Created by yanglikai on 2018/5/25.
 */
@Configuration
@ImportAutoConfiguration({AuthenticationCoreConfig.class})
@EnableConfigurationProperties(MySecurityProperties.class)
public class SecurityCoreConfig {
}
