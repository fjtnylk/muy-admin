package com.muy.admin.config.security;

import com.google.common.collect.Lists;
import com.muy.admin.model.domain.UserDO;
import com.muy.admin.service.UserService;
import com.muy.base.exception.BizException;
import com.muy.security.core.SecurityUser;
import com.muy.security.core.authentication.password.PasswordAuthenticationToken;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by yanglikai on 2018/5/25.
 */
@Slf4j
@Component
public class UserDetailsServiceImpl implements AuthenticationUserDetailsService<PasswordAuthenticationToken> {
  @Resource
  private UserService userService;

  @Override
  public UserDetails loadUserDetails(PasswordAuthenticationToken token) throws UsernameNotFoundException {
    String username = (String) token.getPrincipal();
    String password = (String) token.getCredentials();

    try {
      UserDO user = userService.authUser(username, password);

      return
          SecurityUser.builder()
              .userId(user.getId())
              .userName(user.getUserName())
              .mobile(user.getMobile())
              .authorities(Lists.newArrayList(new SimpleGrantedAuthority("ROLE_USER")))
              .build();
    } catch (BizException ex) {
      throw new InternalAuthenticationServiceException(ex.getMessage());
    }
  }
}
