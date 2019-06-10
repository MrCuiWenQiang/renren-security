package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.RechargeRecordEntity;

import java.util.Map;

/**
 * 充值记录表
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-09 11:53:03
 */
public interface RechargeRecordService extends IService<RechargeRecordEntity> {

    PageUtils queryPage(Map<String, Object> params);
    PageUtils queryCountPage(Map<String, Object> params);
}

