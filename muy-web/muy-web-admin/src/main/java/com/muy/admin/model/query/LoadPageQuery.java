package com.muy.admin.model.query;

import java.util.Date;
import lombok.Data;

/**
 * Created by yanglikai on 2018/6/13.
 */
@Data
public class LoadPageQuery {
  private Integer page;
  private Integer pageSize;
  private String userName;
  private String startTime;
  private String endTime;
}
