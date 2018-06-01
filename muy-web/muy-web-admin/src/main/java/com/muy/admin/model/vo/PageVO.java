package com.muy.admin.model.vo;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * Created by yanglikai on 2018/5/31.
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PageVO<T> implements Serializable {
  private long total;
  private int current;
  private int pageSize;
  private List<T> list;
}
