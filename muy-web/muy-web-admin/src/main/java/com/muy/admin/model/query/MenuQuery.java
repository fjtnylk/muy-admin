package com.muy.admin.model.query;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.io.Serializable;
import javax.validation.constraints.Max;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * Created by yanglikai on 2018/5/23.
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MenuQuery implements Serializable {
  @Max(value = 99999, message = "[id]最大值为99999")
  private Integer id;
  @Max(value = 99999, message = "[bpid]最大值为99999")
  private Integer bpid;
  @Max(value = 99999, message = "[mpid]最大值为99999")
  private Integer mpid;
  @Length(max = 20, message = "[icon]最大长度为20")
  private String icon;
  @Length(max = 32, message = "[name]最大长度为32")
  private String name;
  @Length(max = 64, message = "[route]最大长度为64")
  private String route;
}
