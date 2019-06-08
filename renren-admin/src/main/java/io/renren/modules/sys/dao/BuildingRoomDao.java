package io.renren.modules.sys.dao;

import io.renren.modules.sys.entity.BuildingRoomEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.sys.entity.BuildingRoomListEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 单元房间号
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-05 01:55:52
 */
@Mapper
public interface BuildingRoomDao extends BaseMapper<BuildingRoomEntity> {
    List<BuildingRoomListEntity> queryComList(Map<String, Object> params);
}
