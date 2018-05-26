package com.muy.admin.model.query;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.io.Serializable;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by yanglikai on 2018/5/24.
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CreateUserQuery implements Serializable {
  @NotBlank(message = "[userName]不允许为空")
  private String userName;
  @NotBlank(message = "[password]不允许为空")
  private String password;
  @NotBlank(message = "[mobile]不允许为空")
  private String mobile;
  private String email;
  private String nickName;
  private String birthday;
  private String signature;
  @NotBlank(message = "[sex]不允许为空")
  private String sex;
  private String address;
  @NotBlank(message = "[groupCode]不允许为空")
  private String groupCode;
  @NotBlank(message = "[roleCode]不允许为空")
  private String roleCode;
}
