package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.RechargeEntity;

import java.util.Map;

/**
 * 余额表
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-11 00:36:15
 */
public interface RechargeService extends IService<RechargeEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryCountPage(Map<String, Object> params);
}

