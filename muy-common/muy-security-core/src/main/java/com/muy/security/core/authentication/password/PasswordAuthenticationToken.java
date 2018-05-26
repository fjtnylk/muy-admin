package com.muy.security.core.authentication.password;

import java.util.Collection;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

/**
 * 用户名/密码认证信息.
 * Created by yanglikai on 2018/5/25.
 */
public class PasswordAuthenticationToken extends AbstractAuthenticationToken {
  private final Object username;
  private Object password;

  public PasswordAuthenticationToken(Object username, Object password) {
    super(null);
    this.username = username;
    this.password = password;
    setAuthenticated(false);
  }

  public PasswordAuthenticationToken(Object username, Object password,
                                     Collection<? extends GrantedAuthority> authorities) {
    super(authorities);
    this.username = username;
    this.password = password;
    super.setAuthenticated(true); // must use super, as we override
  }

  @Override
  public Object getCredentials() {
    return password;
  }

  @Override
  public Object getPrincipal() {
    return username;
  }

  @Override
  public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
    if (isAuthenticated) {
      throw new IllegalArgumentException(
          "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
    }

    super.setAuthenticated(false);
  }

  @Override
  public void eraseCredentials() {
    super.eraseCredentials();
    password = null;
  }
}
