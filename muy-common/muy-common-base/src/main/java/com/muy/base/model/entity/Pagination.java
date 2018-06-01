package com.muy.base.model.entity;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * Created by yanglikai on 2018/6/1.
 */
@Data
public class Pagination implements Serializable {
  private long total;   // 总记录数
  private int size;     // 每页显示条数
  private int pages;    // 总页数
  private int current;  // 当前页
  private List records; // 分页记录
}
