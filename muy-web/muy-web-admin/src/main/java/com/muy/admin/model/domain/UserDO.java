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
@Builder
@TableName(value = "my_user")
public class UserDO implements Serializable {
  @TableId(type = IdType.AUTO)
  private Long id;                  // 用户编号
  private String userName;          // 用户名
  private String password;          // 用户密码
  private String salt;              // 盐
  private String mobile;            // 手机号
  private String email;             // 邮箱
  private String nickName;          // 昵称
  private String birthday;          // 生日
  private String signature;         // 签名
  private String sex;               // 性别(F-女,M-男)
  private String avater;            // 头像
  private Integer status;           // 状态(0-可用、1-禁用、2-冻结)
  private String userSource;        // 用户来源
  private String lastLoginIp;       // 最后登录IP
  private String lastLoginLocation; // 最后登录位置
  private Date lastLoginTime;       // 最后登录时间
  @TableField(value = "is_changed_pwd_flg")
  private Boolean changedPwdFlg;    // 是否修改过密码
  private Integer pwdErrorCount;    // 连续输错密码次数
  private Date createTime;          // 创建时间
  private Date updateTime;          // 更新时间
}
