package com.muy.admin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.muy.util.json.JSONUtil;
import lombok.Data;
import org.junit.Test;

/**
 * Created by yanglikai on 2018/6/13.
 */
public class JSONTest {

  @Test
  public void test01() {
    UserDO userDO = new UserDO();
    userDO.setUserName("yanglikai");
    userDO.setMobile("13671803404");
    userDO.setEmail("fjtnylk@126.com");
    System.out.println(JSONUtil.toJSON(userDO));

    UserVO userVO = new UserVO();
    userVO.setUserName("yanglikai");
    userVO.setMobile("13671803404");
    userVO.setEmail("297038802@qq.com");
    System.out.println(JSONUtil.toJSON(userVO));
  }

  @Data
  @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
  public static class UserDO {
    @JsonIgnore
    private String userName;
    private String mobile;
    @JsonIgnore
    private String email;
  }

  @Data
  @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
  public static class UserVO extends UserDO {
    private String email;
  }
}
