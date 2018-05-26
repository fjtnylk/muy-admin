package com.muy.security.core.authentication.password;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 用户名/密码认证提供者.
 * Created by yanglikai on 2018/5/25.
 */
public class PasswordAuthenticationProvider implements AuthenticationProvider {

  private AuthenticationUserDetailsService userDetailsService;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    PasswordAuthenticationToken token = (PasswordAuthenticationToken) authentication;

    UserDetails user = userDetailsService.loadUserDetails(token);

    PasswordAuthenticationToken authenticationResult = new PasswordAuthenticationToken(user, user.getAuthorities());

    authenticationResult.setDetails(token.getDetails());

    return authenticationResult;
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return PasswordAuthenticationToken.class.isAssignableFrom(authentication);
  }

  public void setUserDetailsService(AuthenticationUserDetailsService userDetailsService) {
    this.userDetailsService = userDetailsService;
  }
}
