package com.muy.util.crypto.hash;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Created by yanglikai on 2018/5/24.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SlowEqualsUtil {

  public static boolean slowEquals(byte[] arg1, byte[] arg2) {
    int diff = arg1.length ^ arg2.length;
    for (int i = 0; i < arg1.length && i < arg2.length; i++) {
      diff |= arg1[i] ^ arg2[i];
    }

    return diff == 0;
  }
}
