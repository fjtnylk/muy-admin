package com.muy.admin.model.vo;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.muy.util.mapper.annotation.MapperProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * Created by yanglikai on 2018/6/4.
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TransferItemVO implements Serializable {
  @MapperProperty(value = "code")
  private String key;
  @MapperProperty(value = "name")
  private String title;
  @MapperProperty(value = "name")
  private String description;
  private boolean disabled = false;
}
