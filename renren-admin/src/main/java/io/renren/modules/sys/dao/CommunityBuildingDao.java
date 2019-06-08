package io.renren.modules.sys.dao;

import io.renren.modules.sys.entity.CommunityBuildingEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.sys.entity.CommunityBuildingListEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 楼号
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-05 01:55:52
 */
@Mapper
public interface CommunityBuildingDao extends BaseMapper<CommunityBuildingEntity> {
    List<CommunityBuildingListEntity> queryComList(Map<String, Object> params);
}
