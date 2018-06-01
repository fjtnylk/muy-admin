package com.muy.util.converter.impl;

import com.muy.base.model.entity.Pagination;
import com.muy.base.model.vo.PageVO;
import com.muy.util.converter.AbstractConverter;

/**
 * Created by yanglikai on 2018/6/1.
 */
public class PageConverter extends AbstractConverter<Pagination, PageVO> {

  @Override
  public PageVO convert(final Pagination source) {
    return
        PageVO.builder()
            .total(source.getTotal())
            .current(source.getCurrent())
            .size(source.getSize())
            .list(source.getRecords())
            .build();
  }
}
