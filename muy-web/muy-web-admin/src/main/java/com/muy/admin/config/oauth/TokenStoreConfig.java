package com.muy.admin.config.oauth;

import com.muy.security.core.properties.MySecurityProperties;
import javax.annotation.Resource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * Created by yanglikai on 2018/5/26.
 */
//@Configuration
public class TokenStoreConfig {
  @Resource
  private MySecurityProperties mySecurityProperties;

  @Bean
  public TokenStore jwtTokenStore() {
    return new JwtTokenStore(jwtAccessTokenConverter());
  }

  @Bean
  public JwtAccessTokenConverter jwtAccessTokenConverter() {
    JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
    converter.setSigningKey(mySecurityProperties.getOauth2().getJwtSigningKey());
    return converter;
  }

  @Bean
  @ConditionalOnBean(TokenEnhancer.class)
  public TokenEnhancer jwtTokenEnhancer() {
    return new TokenJwtEnhancer();
  }
}
