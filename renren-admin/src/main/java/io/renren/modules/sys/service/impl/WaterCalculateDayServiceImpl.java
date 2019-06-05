package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.WaterCalculateDayDao;
import io.renren.modules.sys.entity.WaterCalculateDayEntity;
import io.renren.modules.sys.service.WaterCalculateDayService;


@Service("waterCalculateDayService")
public class WaterCalculateDayServiceImpl extends ServiceImpl<WaterCalculateDayDao, WaterCalculateDayEntity> implements WaterCalculateDayService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WaterCalculateDayEntity> page = this.page(
                new Query<WaterCalculateDayEntity>().getPage(params),
                new QueryWrapper<WaterCalculateDayEntity>()
        );

        return new PageUtils(page);
    }

}
