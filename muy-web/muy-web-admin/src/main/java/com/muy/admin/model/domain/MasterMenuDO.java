package com.muy.admin.model.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Created by yanglikai on 2018/5/21.
 */
@Data
@TableName(value = "my_master_menu")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MasterMenuDO implements Serializable {
  @TableId(type = IdType.INPUT)
  private Integer id;
  private Integer bpid;
  private Integer mpid;
  private String icon;
  private String name;
  private String route;
  @TableField(value = "creat_time")
  private Date createTime;
  @TableField(value = "update_time")
  private Date updateTime;
}
