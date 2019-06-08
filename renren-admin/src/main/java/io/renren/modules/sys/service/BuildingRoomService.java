package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.BuildingRoomEntity;

import java.util.Map;

/**
 * 单元房间号
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-05 01:55:52
 */
public interface BuildingRoomService extends IService<BuildingRoomEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryCountPage(Map<String, Object> params);
}

