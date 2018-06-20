package com.muy.admin.model.entity;

import lombok.Builder;
import lombok.Data;

/**
 * Created by yanglikai on 2018/6/20.
 */
@Data
@Builder
public class AddressEntity {
  private String prov;
  private String city;
  private String district;
  private String street;
}
