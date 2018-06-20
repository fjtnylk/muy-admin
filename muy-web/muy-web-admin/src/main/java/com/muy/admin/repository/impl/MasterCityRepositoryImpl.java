package com.muy.admin.repository.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muy.admin.mapper.MasterCityMapper;
import com.muy.admin.model.domain.MasterCityDO;
import com.muy.admin.repository.MasterCityRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2018/6/19.
 */
@Repository
public class MasterCityRepositoryImpl
    extends ServiceImpl<MasterCityMapper, MasterCityDO> implements MasterCityRepository {
}
