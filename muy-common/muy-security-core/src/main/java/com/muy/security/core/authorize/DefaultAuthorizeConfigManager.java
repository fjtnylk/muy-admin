package com.muy.security.core.authorize;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * 默认的授权配置管理器
 *
 * Created by yanglikai on 2018/5/27.
 */
@Configuration
public class DefaultAuthorizeConfigManager implements AuthorizeConfigManager {
  private final List<AuthorizeConfigProvider> authorizeConfigProviders;

  @Autowired
  public DefaultAuthorizeConfigManager(List<AuthorizeConfigProvider> authorizeConfigProviders) {
    this.authorizeConfigProviders = authorizeConfigProviders;
  }

  @Override
  public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
    boolean existAnyRequestConfig = false;
    String existAnyRequestConfigName = null;

    for (AuthorizeConfigProvider authorizeConfigProvider : authorizeConfigProviders) {
      boolean currentIsAnyRequestConfig = authorizeConfigProvider.config(config);
      if (existAnyRequestConfig && currentIsAnyRequestConfig) {
        throw new RuntimeException("重复的anyRequest配置:" + existAnyRequestConfigName + ","
            + authorizeConfigProvider.getClass().getSimpleName());
      } else if (currentIsAnyRequestConfig) {
        existAnyRequestConfig = true;
        existAnyRequestConfigName = authorizeConfigProvider.getClass().getSimpleName();
      }
    }

    if (!existAnyRequestConfig) {
      //config.anyRequest().authenticated();
    }
  }
}
