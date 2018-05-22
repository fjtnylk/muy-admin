package com.muy.admin.model.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Builder;
import lombok.Data;

/**
 * Created by yanglikai on 2018/5/21.
 */
@Data
@Builder
@TableName(value = "my_user_role")
public class UserRoleDO implements Serializable {
  @TableId
  private Long id;
  private Long userId;
  @TableField("r_code")
  private String roleCode;
  private Date createTime;
  private Date updateTime;
}
