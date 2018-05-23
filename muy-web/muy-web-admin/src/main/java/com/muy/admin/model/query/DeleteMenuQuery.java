package com.muy.admin.model.query;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.io.Serializable;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * Created by yanglikai on 2018/5/23.
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class DeleteMenuQuery implements Serializable {
  @NotNull(message = "[menuId]不允许为空")
  @Max(value = 99999, message = "[menuId]最大值为99999")
  private Integer menuId;
}
