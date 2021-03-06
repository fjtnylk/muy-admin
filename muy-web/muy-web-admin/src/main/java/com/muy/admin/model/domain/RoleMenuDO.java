package com.muy.admin.model.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.io.Serializable;
import java.util.Date;
import lombok.Builder;
import lombok.Data;

/**
 * Created by yanglikai on 2018/5/21.
 */
@Data
@TableName(value = "my_role_menu")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RoleMenuDO implements Serializable {
  @TableId(type = IdType.INPUT)
  private String pkey;
  @TableField(value = "r_code")
  private String roleCode;
  @TableField(value = "menu_id")
  private Integer menuId;
  @TableField(value = "create_time")
  private Date createTime;
  @TableField(value = "update_time")
  private Date updateTime;
}
