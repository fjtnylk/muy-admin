package com.muy.security.core.properties;

import lombok.Data;

/**
 * OAuth2安全配置.
 * Created by yanglikai on 2018/5/26.
 */
@Data
public class OAuth2Properties {

  /**
   * 使用jwt时token签名秘钥
   */
  private String jwtSigningKey = "http://www.muy.com";

  /**
   * 客户端配置
   */
  private OAuth2ClientProperties[] clients = {};
}
