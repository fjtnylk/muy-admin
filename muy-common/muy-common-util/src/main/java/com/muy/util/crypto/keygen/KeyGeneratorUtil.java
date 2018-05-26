package com.muy.util.crypto.keygen;

import com.muy.util.crypto.codec.Hex;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.keygen.KeyGenerators;

/**
 * Created by yanglikai on 2018/4/11.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class KeyGeneratorUtil {

  public static String generateKey() {
    return generateKey(32);
  }

  public static String generateKey(int keyLength) {
    return
        new String(Hex.encode(KeyGenerators.secureRandom(keyLength).generateKey()));
  }
}
