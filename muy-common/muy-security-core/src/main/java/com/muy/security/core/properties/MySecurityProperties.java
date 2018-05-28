package com.muy.security.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 系统安全配置.
 * Created by yanglikai on 2018/5/25.
 */
@Data
@ConfigurationProperties(prefix = "muy.security")
public class MySecurityProperties {

  /**
   * OAuth2客户端认证配置
   */
  private OAuth2Properties oauth2 = new OAuth2Properties();
}
