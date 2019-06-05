package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.WaterCalculateDateEntity;

import java.util.Map;

/**
 * 时刻表
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-05 01:55:52
 */
public interface WaterCalculateDateService extends IService<WaterCalculateDateEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

