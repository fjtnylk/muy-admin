package com.muy.base.constant;

/**
 * Created by yanglikai on 2018/5/21.
 */
public final class GlobalConstant {
  public static final String ROOT_PREFIX = "muy";
  public static final String UNKNOWN = "unknown";

  public static final String X_FORWARDED_FOR = "X-Forwarded-For";
  public static final String X_REAL_IP = "X-Real-IP";
  public static final String PROXY_CLIENT_IP = "Proxy-Client-IP";
  public static final String WL_PROXY_CLIENT_IP = "WL-Proxy-Client-IP";
  public static final String HTTP_CLIENT_IP = "HTTP_CLIENT_IP";
  public static final String HTTP_X_FORWARDED_FOR = "HTTP_X_FORWARDED_FOR";

  public static final String LOCALHOST_IP = "127.0.0.1";
  public static final String LOCALHOST_IP_16 = "0:0:0:0:0:0:0:1";
  public static final int MAX_IP_LENGTH = 15;

  /**
   * 数值
   */
  public interface Number {
    int THOUSAND_INT = 1000;
    int HUNDRED_INT = 100;
    int ONE_INT = 1;
    int TWO_INT = 2;
    int THREE_INT = 3;
    int FOUR_INT = 4;
    int FIVE_INT = 5;
    int SIX_INT = 6;
    int SEVEN_INT = 7;
    int EIGHT_INT = 8;
    int NINE_INT = 9;
    int TEN_INT = 10;
    int EIGHTEEN_INT = 18;
  }

  /**
   * 系统常量
   */
  public static final class System {
    private System() {
    }

    public static final String TOKEN_AUTH = "CURRENT_USER";
  }

  /**
   * 符号
   */
  public static final class Symbol {
    private Symbol() {
    }

    public static final String COMMA = ",";

    public static final String SPOT = ".";

    public final static String UNDER_LINE = "_";

    public final static String PER_CENT = "%";

    public final static String AT = "@";

    public final static String PIPE = "||";

    public final static String SHORT_LINE = "-";

    public final static String SPACE = " ";

    public static final String SLASH = "/";

    public static final String MH = ":";
  }
}
