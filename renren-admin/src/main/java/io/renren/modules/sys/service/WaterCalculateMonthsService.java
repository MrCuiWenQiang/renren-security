package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.WaterCalculateMonthsEntity;

import java.util.Map;

/**
 * 月份表
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-05 01:55:52
 */
public interface WaterCalculateMonthsService extends IService<WaterCalculateMonthsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

