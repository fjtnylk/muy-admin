package com.muy.admin.config.oauth;

import java.util.HashMap;
import java.util.Map;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

/**
 * OAuth返回Token自定义.
 * Created by yanglikai on 2018/5/26.
 */
public class TokenJwtEnhancer implements TokenEnhancer {

  @Override
  public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication oAuth2Authentication) {
    Map<String, Object> additionalInfo = new HashMap<>(8);
    additionalInfo.put("timestamp", System.currentTimeMillis());

    Authentication authentication = oAuth2Authentication.getUserAuthentication();
    if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
      Object principal = authentication.getPrincipal();
      additionalInfo.put("login_name", ((UserDetails) principal).getUsername());
    }

    ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);

    return accessToken;
  }
}
