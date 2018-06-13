package com.muy.admin.model.query;

import java.io.Serializable;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by yanglikai on 2018/6/13.
 */
@Data
public class SaveUserQuery implements Serializable {
  @NotBlank(message = "[userName]不允许为空")
  private String userName;
  @NotBlank(message = "[mobile]不允许为空")
  private String mobile;
  private String email;
  private String birthday;
  @NotBlank(message = "[sex]不允许为空")
  private String sex;
  private String address;
  @NotBlank(message = "[groupCode]不允许为空")
  private String groupCode;
  @NotBlank(message = "[roleCode]不允许为空")
  private String roleCode;
}
