package com.muy.base.model.vo;

import java.io.Serializable;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * Created by yanglikai on 2018/6/1.
 */
@Data
@Builder
public class PageVO implements Serializable {
  private long total;
  private int current;
  private int size;
  private List list;
}
