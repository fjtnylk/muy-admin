package com.muy.admin.model.query;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.io.Serializable;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by yanglikai on 2018/5/23.
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CodeNameQuery implements Serializable {
  @NotBlank(message = "[code]不允许为空")
  @Length(max = 3, message = "[code]最大长度为3")
  private String code;
  @NotBlank(message = "[name]不允许为空")
  @Length(max = 20, message = "[name]最大长度为20")
  private String name;
  @Length(max = 50, message = "[remark]最大长度为50")
  private String remark;
}
