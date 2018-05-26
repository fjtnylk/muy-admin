package com.muy.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.muy.admin.model.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by yanglikai on 2018/5/24.
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
}
