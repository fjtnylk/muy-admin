package com.muy.admin.model.vo;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

/**
 * Created by yanglikai on 2018/5/24.
 */
@Data
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CreateUserVO implements Serializable {
  private Long userId;
  private String userName;
}
