package io.renren.modules.sys.dao;

import io.renren.modules.sys.entity.RechargeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.sys.entity.RechargeListEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 余额表
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-11 00:36:15
 */
@Mapper
public interface RechargeDao extends BaseMapper<RechargeEntity> {
    List<RechargeListEntity> queryComList(Map<String, Object> params);
}
