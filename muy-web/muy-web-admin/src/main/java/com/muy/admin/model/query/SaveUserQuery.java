package com.muy.admin.model.query;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by yanglikai on 2018/6/13.
 */
@Data
public class SaveUserQuery implements Serializable {
  @NotBlank(message = "[name]不允许为空")
  private String name;
  private String nickName;
  private Integer age;
  @NotBlank(message = "[mobile]不允许为空")
  private String mobile;
  private String email;
  @NotBlank(message = "[sex]不允许为空")
  private String sex;
  private List<String> address;
  private List<String> position;
}
