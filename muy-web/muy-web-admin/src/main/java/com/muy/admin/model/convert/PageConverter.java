package com.muy.admin.model.convert;

import com.baomidou.mybatisplus.plugins.Page;
import com.muy.admin.model.vo.PageVO;

/**
 * Created by yanglikai on 2018/6/1.
 */
public class PageConverter {
  private Page page;

  public PageConverter(Page page) {
    this.page = page;
  }

  public PageVO convert() {
    PageVO target = new PageVO();
    target.setTotal(page.getTotal());
    target.setCurrent(page.getCurrent());
    target.setPageSize(page.getSize());
    target.setList(page.getRecords());

    return target;
  }
}
