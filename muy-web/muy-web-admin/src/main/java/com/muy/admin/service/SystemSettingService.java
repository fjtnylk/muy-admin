package com.muy.admin.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.muy.admin.model.domain.MasterGroupDO;
import com.muy.admin.model.query.CreateGroupQuery;
import com.muy.admin.model.query.UpdateGroupQuery;
import com.muy.admin.repository.MasterGroupRepository;
import com.muy.util.mapper.MapperUtil;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

/**
 * 系统设置.
 * Created by yanglikai on 2018/5/22.
 */
@Service
public class SystemSettingService {
  @Resource
  private MasterGroupRepository masterGroupRepository;

  /**
   * 创建组织.
   *
   * @param query
   * @return
   */
  public boolean createMasterGroup(CreateGroupQuery query) {
    MasterGroupDO target = MapperUtil.map(query, MasterGroupDO.class);
    return masterGroupRepository.insert(target);
  }

  /**
   * 更新组织.
   *
   * @param query
   * @return
   */
  public boolean updateMasterGroup(UpdateGroupQuery query) {
    MasterGroupDO entity = MapperUtil.map(query, MasterGroupDO.class);
    entity.setUpdateTime(new Date());

    Wrapper wrapper =
        new EntityWrapper()
            .where("code={0}", entity.getCode());

    return masterGroupRepository.update(entity, wrapper);
  }

  /**
   * 加载所有组织信息.
   *
   * @return
   */
  public List<MasterGroupDO> loadAll4Group() {
    return masterGroupRepository.selectAllGroup();
  }
}
