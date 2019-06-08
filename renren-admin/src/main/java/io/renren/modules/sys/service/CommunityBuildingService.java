package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.CommunityBuildingEntity;

import java.util.List;
import java.util.Map;

/**
 * 楼号
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-05 01:55:52
 */
public interface CommunityBuildingService extends IService<CommunityBuildingEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryCountPage(Map<String, Object> params);

     List<CommunityBuildingEntity> queryListByComId(int id);
}

