package com.muy.admin.model.vo;

import java.io.Serializable;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * Created by yanglikai on 2018/5/30.
 */
@Data
@Builder
public class LoadGroupsVO implements Serializable {
  private int total;
  private int current;
  private List<GroupVO> list;

  @Data
  @Builder
  public static class GroupVO implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private String address;
  }
}
