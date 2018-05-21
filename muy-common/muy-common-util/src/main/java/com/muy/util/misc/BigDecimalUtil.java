package com.muy.util.misc;

import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Created by yanglikai on 2018/5/21.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BigDecimalUtil {

  /**
   * Add big decimal.
   *
   * @param v1
   * @param v2
   * @return
   */
  public static BigDecimal add(double v1, double v2) {
    return add(Double.toString(v1), Double.toString(v2));
  }

  /**
   * Add big decimal.
   *
   * @param v1
   * @param v2
   * @return
   */
  public static BigDecimal add(String v1, String v2) {
    BigDecimal b1 = new BigDecimal(v1);
    BigDecimal b2 = new BigDecimal(v2);
    return b1.add(b2);
  }

  /**
   * Sub big decimal.
   *
   * @param v1
   * @param v2
   * @return
   */
  public static BigDecimal sub(double v1, double v2) {
    return sub(Double.toString(v1), Double.toString(v2));
  }

  /**
   * Sub big decimal.
   *
   * @param v1
   * @param v2
   * @return
   */
  public static BigDecimal sub(String v1, String v2) {
    BigDecimal b1 = new BigDecimal(v1);
    BigDecimal b2 = new BigDecimal(v2);
    return b1.subtract(b2);
  }

  /**
   * Mul big decimal.
   *
   * @param v1
   * @param v2
   * @return
   */
  public static BigDecimal mul(double v1, double v2) {
    return mul(Double.toString(v1), Double.toString(v2));
  }

  /**
   * Mul big decimal.
   *
   * @param v1
   * @param v2
   * @return
   */
  public static BigDecimal mul(String v1, String v2) {
    BigDecimal b1 = new BigDecimal(v1);
    BigDecimal b2 = new BigDecimal(v2);
    return b1.multiply(b2);
  }

  /**
   * Div big decimal.
   *
   * @param v1
   * @param v2
   * @return
   */
  public static BigDecimal div(double v1, double v2) {
    return div(Double.toString(v1), Double.toString(v2));
  }

  /**
   * Div big decimal.
   *
   * @param v1
   * @param v2
   * @return
   */
  public static BigDecimal div(String v1, String v2) {
    BigDecimal b1 = new BigDecimal(v1);
    BigDecimal b2 = new BigDecimal(v2);
    return b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP);
  }
}
