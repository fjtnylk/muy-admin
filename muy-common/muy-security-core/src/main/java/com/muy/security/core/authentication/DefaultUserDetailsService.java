package com.muy.security.core.authentication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by yanglikai on 2018/5/25.
 */
@Slf4j
public class DefaultUserDetailsService implements AuthenticationUserDetailsService {
  @Override
  public UserDetails loadUserDetails(Authentication token) throws UsernameNotFoundException {
    log.warn("请配置 UserDetailsService 接口的实现.");
    throw new UsernameNotFoundException((String) token.getPrincipal());
  }
}
