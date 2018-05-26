package com.muy.admin.model.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.muy.util.mapper.annotation.MapperProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * Created by yanglikai on 2018/5/24.
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class LoadUserVO implements Serializable {
  @MapperProperty(value = "id")
  private Long userId;
  private String userName;
  private String mobile;
  private String email;
  private String nickName;
  private String sex;
  private String address;
}
