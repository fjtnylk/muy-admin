package com.muy.base.model.entity;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * Created by yanglikai on 2018/6/1.
 */
@Data
public class Pagination<T> implements Serializable {
  private long total;      // 总记录数
  private int size;        // 每页显示条数
  private long pages;      // 总页数
  private int current;     // 当前页
  private List<T> records; // 分页记录
}
