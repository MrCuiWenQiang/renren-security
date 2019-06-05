package io.renren.modules.sys.dao;

import io.renren.modules.sys.entity.BuildingRoomEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 单元房间号
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-05 01:55:52
 */
@Mapper
public interface BuildingRoomDao extends BaseMapper<BuildingRoomEntity> {
	
}
