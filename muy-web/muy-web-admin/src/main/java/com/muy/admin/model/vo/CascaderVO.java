package com.muy.admin.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * 级联选择
 * Created by yanglikai on 2018/6/19.
 */
@Data
@Builder
public class CascaderVO implements Serializable {
  @JsonIgnore
  private String id;
  @JsonIgnore
  private String pid;
  private String value;
  private String label;
  private List<CascaderVO> children;
}
