package com.muy.security.core.authentication.sms;

import java.util.Collection;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

/**
 * 短息登录认证信息.
 * <p>
 * Created by yanglikai on 2018/5/25.
 */
public class SMSAuthenticationToken extends AbstractAuthenticationToken {
  private final Object mobile;

  public SMSAuthenticationToken(String mobile) {
    super(null);
    this.mobile = mobile;
    super.setAuthenticated(false);
  }

  public SMSAuthenticationToken(Object mobile, Collection<? extends GrantedAuthority> authorities) {
    super(authorities);
    this.mobile = mobile;
    super.setAuthenticated(true); // must use super, as we override
  }

  @Override
  public Object getCredentials() {
    return null;
  }

  @Override
  public Object getPrincipal() {
    return mobile;
  }

  @Override
  public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
    if (isAuthenticated) {
      throw new IllegalArgumentException(
          "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
    }

    super.setAuthenticated(false);
  }
}
