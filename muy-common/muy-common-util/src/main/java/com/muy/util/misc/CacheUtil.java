package com.muy.util.misc;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Created by yanglikai on 2018/6/20.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CacheUtil {
  private static final Cache<String, String> cache;

  static {
    cache =
        CacheBuilder.newBuilder()
            .initialCapacity(200)
            .concurrencyLevel(5)
            .build();
  }

  public static void put(String key, String value) {
    cache.put(key, value);
  }

  public static String get(String key) {
    return cache.getIfPresent(key);
  }
}
