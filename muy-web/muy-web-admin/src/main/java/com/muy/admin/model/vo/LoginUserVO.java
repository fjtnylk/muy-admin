package com.muy.admin.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.io.Serializable;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * Created by yanglikai on 2018/5/25.
 */
@Data
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class LoginUserVO implements Serializable {
  private Long userId;
  private String userName;
  private Permissions permissions;

  @Data
  @Builder
  @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
  public static class Permissions implements Serializable {
    @JsonProperty(value = "visit")
    private List<String> visit;
    @JsonProperty(value = "role")
    private String role;
  }
}
