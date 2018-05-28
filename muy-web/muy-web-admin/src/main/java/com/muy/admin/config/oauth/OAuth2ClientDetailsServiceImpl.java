package com.muy.admin.config.oauth;

import com.muy.security.core.properties.OAuth2ClientProperties;
import com.muy.security.core.properties.MySecurityProperties;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Component;

/**
 * Created by yanglikai on 2018/5/26.
 */
@Slf4j
//@Component
public class OAuth2ClientDetailsServiceImpl implements ClientDetailsService {

  private ClientDetailsService clientDetailsService;

  @Resource
  private MySecurityProperties mySecurityProperties;

  @PostConstruct
  public void init() {
    InMemoryClientDetailsServiceBuilder builder = new InMemoryClientDetailsServiceBuilder();

    if (ArrayUtils.isNotEmpty(mySecurityProperties.getOauth2().getClients())) {
      for (OAuth2ClientProperties client : mySecurityProperties.getOauth2().getClients()) {
        builder.withClient(client.getClientId())
            .secret(client.getClientSecret())
            .authorizedGrantTypes("refresh_token", "password", "client_credentials")
            .accessTokenValiditySeconds(client.getAccessTokenValidateSeconds())
            .refreshTokenValiditySeconds(client.getRefreshTokenValiditySeconds())
            .scopes(client.getScope());
      }
    }

    try {
      clientDetailsService = builder.build();
    } catch (Exception e) {
      log.error("init={}", e.getMessage(), e);
    }
  }

  @Override
  public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
    return clientDetailsService.loadClientByClientId(clientId);
  }
}
