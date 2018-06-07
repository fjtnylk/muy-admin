package com.muy.admin.model.query;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by yanglikai on 2018/5/24.
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SaveRoleMenuQuery implements Serializable {
  @NotBlank(message = "[roleCode]不允许为空")
  @Length(max = 3, message = "[roleCode]最大长度为3")
  private String roleCode;
  @NotNull
  private List<String> menus;
}
