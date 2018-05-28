package com.muy.security.core.properties;

import lombok.Data;

/**
 * OAuth客户端应用配置.
 * Created by yanglikai on 2018/5/26.
 */
@Data
public class OAuth2ClientProperties {
  /**
   * 客户端应用appid
   */
  private String clientId;

  /**
   * 客户端应用秘钥
   */
  private String clientSecret;

  /**
   * 客户端应用作用域
   */
  private String scope;

  /**
   * 针对此应用发出的token的有效时间
   */
  private int accessTokenValidateSeconds = 7200;

  /**
   * 针对此应用发出的token的刷新有效时间
   */
  private int refreshTokenValiditySeconds = 2592000;
}
