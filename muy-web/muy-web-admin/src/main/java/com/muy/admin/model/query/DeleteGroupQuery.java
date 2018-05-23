package com.muy.admin.model.query;

import java.io.Serializable;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by yanglikai on 2018/5/23.
 */
@Data
public class DeleteGroupQuery implements Serializable {
  @NotBlank(message = "[code]不允许为空")
  @Length(max = 3, message = "[code]最大长度为3")
  private String code;
}
