package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.WaterCalculateYearDao;
import io.renren.modules.sys.entity.WaterCalculateYearEntity;
import io.renren.modules.sys.service.WaterCalculateYearService;


@Service("waterCalculateYearService")
public class WaterCalculateYearServiceImpl extends ServiceImpl<WaterCalculateYearDao, WaterCalculateYearEntity> implements WaterCalculateYearService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WaterCalculateYearEntity> page = this.page(
                new Query<WaterCalculateYearEntity>().getPage(params),
                new QueryWrapper<WaterCalculateYearEntity>()
        );

        return new PageUtils(page);
    }

}
