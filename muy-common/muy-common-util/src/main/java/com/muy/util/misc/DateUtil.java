package com.muy.util.misc;

import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Created by yanglikai on 2018/5/21.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DateUtil {
  private static final String FORMAT_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";

  public static String formatTime(Date date) {
    SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_YYYYMMDDHHMMSS);
    return sdf.format(date);
  }

  public static String formatTime(Date date, String pattern) {
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    return sdf.format(date);
  }
}
