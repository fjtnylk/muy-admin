package com.muy.admin.model.query;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

/**
 * Created by yanglikai on 2018/5/22.
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CreateGroupQuery extends CodeNameQuery {
  private String remark;
}
