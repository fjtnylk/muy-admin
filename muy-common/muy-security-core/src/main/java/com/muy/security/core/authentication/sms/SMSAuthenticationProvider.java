package com.muy.security.core.authentication.sms;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 短信登录认证提供者.
 * <p>
 * Created by yanglikai on 2018/5/25.
 */
public class SMSAuthenticationProvider implements AuthenticationProvider {

  private AuthenticationUserDetailsService userDetailsService;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {

    SMSAuthenticationToken authenticationToken = (SMSAuthenticationToken) authentication;

    UserDetails user = userDetailsService.loadUserDetails(authenticationToken);

    SMSAuthenticationToken authenticationResult = new SMSAuthenticationToken(user, user.getAuthorities());

    authenticationResult.setDetails(authenticationToken.getDetails());

    return authenticationResult;
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return SMSAuthenticationToken.class.isAssignableFrom(authentication);
  }

  public void setUserDetailsService(AuthenticationUserDetailsService userDetailsService) {
    this.userDetailsService = userDetailsService;
  }
}
