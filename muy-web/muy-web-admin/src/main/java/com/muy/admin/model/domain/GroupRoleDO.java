package com.muy.admin.model.domain;

import com.baomidou.mybatisplus.annotations.TableField;
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
@TableName(value = "my_group_role")
public class GroupRoleDO implements Serializable {
  @TableId(type = IdType.INPUT)
  private String pkey;
  @TableField(value = "g_code")
  private String groupCode;
  @TableField(value = "r_code")
  private String roleCode;
  @TableField(value = "create_time")
  private Date createTime;
  @TableField(value = "update_time")
  private Date updateTime;
}
