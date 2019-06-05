package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.WaterCalculateMonthsDao;
import io.renren.modules.sys.entity.WaterCalculateMonthsEntity;
import io.renren.modules.sys.service.WaterCalculateMonthsService;


@Service("waterCalculateMonthsService")
public class WaterCalculateMonthsServiceImpl extends ServiceImpl<WaterCalculateMonthsDao, WaterCalculateMonthsEntity> implements WaterCalculateMonthsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WaterCalculateMonthsEntity> page = this.page(
                new Query<WaterCalculateMonthsEntity>().getPage(params),
                new QueryWrapper<WaterCalculateMonthsEntity>()
        );

        return new PageUtils(page);
    }

}
