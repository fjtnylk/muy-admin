package com.muy.admin.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.muy.admin.model.domain.MasterCityDO;
import com.muy.admin.model.vo.CascaderVO;
import com.muy.admin.repository.MasterCityRepository;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Created by yanglikai on 2018/6/19.
 */
@Service
public class CityService {
  @Resource
  private MasterCityRepository cityRepository;

  /**
   * 级联选择加载.
   *
   * @return
   */
  public List<CascaderVO> loadCascader() {
    List<MasterCityDO> cityAll = cityRepository.selectList(new EntityWrapper<>());

    /* 城市固定化转换 - 城市树化转换 */
    return tree(fixed(cityAll));
  }

  private List<MasterCityDO.CityFixed> fixed(List<MasterCityDO> target) {
    if (target == null) {
      return Lists.newArrayList();
    }

    List<MasterCityDO.CityFixed> fixed = Lists.newArrayList();
    for (MasterCityDO item : target) {
      String id = item.getCode();
      String name = item.getName();
      String pid = null;

      if ("0000".equals(id.substring(2, 6)) == false) {
        pid =
            id.substring(4, 6).equals("00")
                ? id.substring(0, 2).concat("0000")
                : id.substring(0, 4).concat("00");
      }

      MasterCityDO.CityFixed city =
          MasterCityDO.CityFixed.builder()
              .id(id)
              .pid(pid)
              .name(name)
              .build();

      fixed.add(city);
    }

    return fixed;
  }

  private List<CascaderVO> tree(List<MasterCityDO.CityFixed> target) {
    if (target == null) {
      return Lists.newArrayList();
    }

    Map<String, CascaderVO> mapping = Maps.newHashMap();
    for (MasterCityDO.CityFixed item : target) {
      CascaderVO cascader =
          CascaderVO.builder()
              .id(item.getId())
              .pid(item.getPid())
              .value(item.getId())
              .label(item.getName()).build();

      mapping.put(item.getId(), cascader);
    }

    List<CascaderVO> result = Lists.newArrayList();
    for (MasterCityDO.CityFixed item : target) {
      if (item.getPid() == null) {
        result.add(mapping.get(item.getId()));
        continue;
      }

      CascaderVO parent = mapping.get(item.getPid());
      if (parent == null) {
        continue;
      }

      if (parent.getChildren() == null) {
        parent.setChildren(Lists.newArrayList());
      }

      parent.getChildren().add(mapping.get(item.getId()));
    }

    return result;
  }
}
