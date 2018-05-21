package com.muy.base.exception;


import com.muy.base.enums.ErrorCodeEnum;

/**
 * Created by yanglikai on 2018/5/21.
 */
public class BizException extends RuntimeException {
  protected int code;

  public BizException() {
  }

  public BizException(String message) {
    super(message);
  }

  public BizException(Throwable cause) {
    super(cause);
  }

  public BizException(String message, Throwable cause) {
    super(message, cause);
  }

  public BizException(int code, String message) {
    super(message);
    this.code = code;
  }

  public BizException(int code, String messageFormat, Object... args) {
    super(String.format(messageFormat, args));
    this.code = code;
  }

  public BizException(ErrorCodeEnum codeEnum, Object... args) {
    super(String.format(codeEnum.msg(), args));
    this.code = codeEnum.code();
  }

  public int getCode() {
    return code;
  }

  public void setCode() {
    this.code = code;
  }
}
