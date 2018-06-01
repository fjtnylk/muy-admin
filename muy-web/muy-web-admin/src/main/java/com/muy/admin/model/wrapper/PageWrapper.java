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
    Pagination pagination = MapperUtil.map(page, Pagination.class);

    return convert.convert(pagination);
  }
}
