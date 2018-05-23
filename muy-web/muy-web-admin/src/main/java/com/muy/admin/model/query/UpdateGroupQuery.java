package com.muy.admin.model.query;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.io.Serializable;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by yanglikai on 2018/5/22.
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UpdateGroupQuery implements Serializable {
  @NotBlank(message = "code不允许为空")
  private String code;
  @NotBlank(message = "name不允许为空")
  private String name;
  private String remark;
}
