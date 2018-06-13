package com.muy.admin.model.query;

import java.io.Serializable;
import lombok.Data;

/**
 * Created by yanglikai on 2018/6/13.
 */
@Data
public class DeleteUserQuery implements Serializable {
  private Long userId;
}
