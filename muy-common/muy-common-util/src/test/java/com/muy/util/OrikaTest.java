package com.muy.util;

import com.muy.util.mapper.MapperUtil;
import com.muy.util.mapper.annotation.MapperProperty;
import lombok.Data;
import org.junit.Test;

/**
 * Created by yanglikai on 2018/6/7.
 */
public class OrikaTest {

  @Test
  public void test01() {
    Source1 s1 = new Source1();
    s1.setId("10001");
    s1.setName("菜单1");

    Dest dest = MapperUtil.map(s1, Dest.class);
    System.out.println(dest);

    Source2 s2 = new Source2();
    s2.setCode("R01");
    s2.setName("角色");
    Dest dest2 = MapperUtil.map(s2, Dest.class);
    System.out.println(dest2);
  }

  @Data
  public static class Source1 {
    private String id;
    private String name;
  }

  @Data
  public static class Source2 {
    private String code;
    private String name;
  }

  @Data
  public static class Dest {
    @MapperProperty(value = {"id", "code"})
    private String key;
    @MapperProperty(value = "name")
    private String desc;
  }
}
