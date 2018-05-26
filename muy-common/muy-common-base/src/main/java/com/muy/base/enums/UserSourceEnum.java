package com.muy.base.enums;

/**
 * Created by yanglikai on 2018/5/24.
 */
public enum UserSourceEnum {
  REGISTER("REGISTER", "注册"),
  INSERT("INSERT", "后台新增"),
  IMPORT("IMPORT", "后台导入"),
  APP("APP", "手机");

  public String code;
  public String desc;

  UserSourceEnum(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }
}
