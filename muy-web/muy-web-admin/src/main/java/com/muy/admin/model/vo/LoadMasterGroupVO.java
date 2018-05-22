package com.muy.admin.model.vo;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Created by yanglikai on 2018/5/22.
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class LoadMasterGroupVO implements Serializable {
  private String code;
  private String name;
  private String remark;
  private Date createTime;
  private Date updateTime;
}
