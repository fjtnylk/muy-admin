package com.muy.admin.model.domain;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.io.Serializable;
import java.util.Date;
import lombok.Builder;
import lombok.Data;

/**
 * Created by yanglikai on 2018/5/21.
 */
@Data
@Builder
@TableName(value = "my_master_menu")
public class MasterMenuDO implements Serializable {
  @TableId(type = IdType.INPUT)
  private Integer id;
  private Integer bpid;
  private Integer mpid;
  private String icon;
  private String name;
  private String route;
  private Date createTime;
  private Date updateTime;
}
