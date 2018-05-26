package com.muy.util.crypto.hash;

import com.muy.util.crypto.codec.Hex;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Created by yanglikai on 2018/5/24.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Md5DigestUtil {

  private static MessageDigest getMd5Digest() {
    try {
      return MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  public static byte[] md5(byte[] data) {
    return getMd5Digest().digest(data);
  }

  public static byte[] md5(String data) {
    return md5(data.getBytes());
  }

  public static String md5Hex(byte[] data) {
    return new String(Hex.encode(md5(data)));
  }

  public static String md5Hex(String data) {
    return new String(Hex.encode(md5(data)));
  }
}
