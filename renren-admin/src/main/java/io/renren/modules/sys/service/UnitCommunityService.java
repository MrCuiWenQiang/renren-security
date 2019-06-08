package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.UnitCommunityEntity;

import java.util.List;
import java.util.Map;

/**
 * 小区号
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-05 01:55:52
 */
public interface UnitCommunityService extends IService<UnitCommunityEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<UnitCommunityEntity> quaryAll(Long userId);

    PageUtils queryCountPage(Map<String, Object> params);
}

