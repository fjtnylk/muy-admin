package com.muy.config;

import com.muy.config.properties.MuyProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yanglikai on 2018/5/21.
 */
@Configuration
@EnableConfigurationProperties(MuyProperties.class)
public class MuyCoreConfig {
}
