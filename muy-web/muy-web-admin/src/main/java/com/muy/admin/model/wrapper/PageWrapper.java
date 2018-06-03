package com.muy.admin.model.wrapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.muy.base.model.entity.Pagination;
import com.muy.base.model.vo.PageVO;
import com.muy.util.converter.impl.PageConverter;
import com.muy.util.mapper.MapperUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Created by yanglikai on 2018/6/1.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PageWrapper {

  private static final PageConverter convert = new PageConverter();

  public static PageVO wrap(Page page) {
    Pagination pagination = new Pagination();
    pagination.setRecords(page.getRecords());
    pagination.setTotal(page.getTotal());
    pagination.setCurrent(page.getCurrent());
    pagination.setPages(page.getPages());
    pagination.setSize(page.getSize());

    return convert.convert(pagination);
  }
}
