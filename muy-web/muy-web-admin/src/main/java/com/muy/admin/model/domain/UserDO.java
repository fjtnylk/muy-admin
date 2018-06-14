package com.muy.admin.model.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.muy.util.mapper.annotation.MapperProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Builder;
import lombok.Data;

/**
 * Created by yanglikai on 2018/5/21.
 */
@Data
@TableName(value = "my_user")
public class UserDO implements Serializable {
  @TableId(type = IdType.AUTO)
  private Long id;                  // 用户编号
  @JsonProperty(value = "name")
  private String userName;          // 用户名
  @JsonIgnore
  private String password;          // 用户密码
  @JsonIgnore
  private String salt;              // 盐
  private Integer age;              // 年龄
  private String mobile;            // 手机号
  private String email;             // 邮箱
  private String nickName;          // 昵称
  private String birthday;          // 生日
  private String signature;         // 签名
  private String sex;               // 性别(F-女,M-男)
  private String avater;            // 头像
  private String address;           // 地址
  @JsonIgnore
  private Integer status;           // 状态(0-可用、1-禁用、2-冻结)
  @JsonIgnore
  private String userSource;        // 用户来源
  @JsonIgnore
  private String lastLoginIp;       // 最后登录IP
  @JsonIgnore
  private String lastLoginLocation; // 最后登录位置
  @JsonIgnore
  private Date lastLoginTime;       // 最后登录时间
  @TableField(value = "is_changed_pwd_flg")
  @JsonIgnore
  private Boolean changedPwdFlg;    // 是否修改过密码
  @JsonIgnore
  private Integer pwdErrorCount;    // 连续输错密码次数
  @TableField(value = "create_time")
  private Date createTime;          // 创建时间
  @TableField(value = "update_time")
  @JsonIgnore
  private Date updateTime;          // 更新时间
}
