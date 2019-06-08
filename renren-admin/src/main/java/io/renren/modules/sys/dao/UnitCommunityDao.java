package io.renren.modules.sys.dao;

import io.renren.modules.sys.entity.UnitCommunityEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.sys.entity.UnitCommunityListEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 小区号
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-05 01:55:52
 */
@Mapper
public interface UnitCommunityDao extends BaseMapper<UnitCommunityEntity> {
    List<UnitCommunityListEntity> queryComList(Map<String, Object> params);
}
