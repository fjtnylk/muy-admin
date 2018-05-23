package com.muy.admin.model.query;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.io.Serializable;
import lombok.Data;

/**
 * Created by yanglikai on 2018/5/23.
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CreateMenuQuery implements Serializable {
  private Integer id;
  private Integer bpid;
  private Integer mpid;
  private String icon;
  private String name;
  private String route;
}
