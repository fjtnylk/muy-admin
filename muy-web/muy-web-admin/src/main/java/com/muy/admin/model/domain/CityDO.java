package com.muy.admin.model.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Created by yanglikai on 2018/6/14.
 */
@Data
@TableName(value = "my_master_city")
public class CityDO implements Serializable {
  @TableId(type = IdType.INPUT)
  private String code;
  private String name;
  @TableField(value = "create_time")
  private Date createTime;
  @TableField(value = "update_time")
  private Date updateTime;
}
