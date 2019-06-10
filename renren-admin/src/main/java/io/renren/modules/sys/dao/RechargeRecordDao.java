package io.renren.modules.sys.dao;

import io.renren.modules.sys.entity.RechargeRecordEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.sys.entity.RechargeRecordListEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 充值记录表
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-09 11:53:03
 */
@Mapper
public interface RechargeRecordDao extends BaseMapper<RechargeRecordEntity> {
    List<RechargeRecordListEntity> queryComList(Map<String, Object> params);
}
