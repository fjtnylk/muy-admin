package com.muy.util.excel.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by yanglikai on 2018/5/21.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface ExportField {
  /**
   * 索引(从0开始).
   *
   * @return
   */
  int index();

  /**
   * 标题.
   *
   * @return
   */
  String title() default "";

  /**
   * 字段名称.
   *
   * @return
   */
  String name();
}
