package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.WaterCalculateDayEntity;

import java.util.Map;

/**
 * 日份表
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-05 01:55:52
 */
public interface WaterCalculateDayService extends IService<WaterCalculateDayEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

