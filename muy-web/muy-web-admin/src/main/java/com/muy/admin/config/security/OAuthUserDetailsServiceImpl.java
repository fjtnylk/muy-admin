package com.muy.admin.config.security;

import com.google.common.collect.Lists;
import com.muy.admin.model.domain.UserDO;
import com.muy.admin.service.UserService;
import com.muy.base.enums.ErrorCodeEnum;
import com.muy.base.exception.BizException;
import com.muy.security.core.SecurityUser;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by yanglikai on 2018/5/26.
 */
@Slf4j
//@Component
public class OAuthUserDetailsServiceImpl implements UserDetailsService {
  @Resource
  private UserService userService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    try {
      UserDO user = userService.loadUserByUsername(username);
      if (user == null) {
        throw new BizException(ErrorCodeEnum.UMC10012001);
      }

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
