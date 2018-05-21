package com.muy.util.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import lombok.Data;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Created by yanglikai on 2018/5/21.
 */
@Data
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Wrapper<T> implements Serializable {
  public static final int SUCCESS_CODE = 200;

  public static final String SUCCESS_MESSAGE = "ok";

  public static final int ERROR_CODE = 500;

  public static final String ERROR_MESSAGE = "内部异常";

  public static final int ILLEGAL_ARGUMENT_CODE = 100;

  public static final String ILLEGAL_ARGUMENT_MESSAGE = "参数非法";


  private int code;
  private String message;
  private T result;

  public Wrapper() {
    this(SUCCESS_CODE, SUCCESS_MESSAGE);
  }

  public Wrapper(int code, String message) {
    this(code, message, null);
  }

  public Wrapper(int code, String message, T result) {
    super();
    this.code(code).message(message).result(result);
  }

  private Wrapper<T> code(int code) {
    this.setCode(code);
    return this;
  }

  private Wrapper<T> message(String message) {
    this.setMessage(message);
    return this;
  }

  public Wrapper<T> result(T result) {
    this.setResult(result);
    return this;
  }

  @JsonIgnore
  public boolean success() {
    return Wrapper.SUCCESS_CODE == this.code;
  }

  @JsonIgnore
  public boolean error() {
    return !success();
  }
}
