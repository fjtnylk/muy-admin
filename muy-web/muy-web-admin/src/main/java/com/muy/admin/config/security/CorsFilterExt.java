package com.muy.admin.config.security;

import java.util.Arrays;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Created by yanglikai on 2018/5/26.
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilterExt extends CorsFilter {

  public CorsFilterExt() {
    super(corsConfigSource());
  }

  private static CorsConfigurationSource corsConfigSource() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", corsConfig());
    return source;
  }

  private static CorsConfiguration corsConfig() {
    CorsConfiguration corsConfig = new CorsConfiguration();
    corsConfig.addAllowedOrigin("*");
    corsConfig.addAllowedHeader("X-Token");
    corsConfig.addExposedHeader("X-Token");
    corsConfig.setAllowedMethods(Arrays.asList("POST", "GET", "DELETE", "PUT", "OPTIONS"));

    corsConfig.setMaxAge(36000L);
    corsConfig.setAllowCredentials(true);
    return corsConfig;
  }
}
