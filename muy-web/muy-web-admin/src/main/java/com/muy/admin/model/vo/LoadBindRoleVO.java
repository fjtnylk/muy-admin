package com.muy.admin.model.vo;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * Created by yanglikai on 2018/6/4.
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class LoadBindRoleVO implements Serializable {
  private List<TransferItemVO> source;
  private List<String> targetKeys;
}
