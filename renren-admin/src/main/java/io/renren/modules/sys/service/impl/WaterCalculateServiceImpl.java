package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.WaterCalculateDao;
import io.renren.modules.sys.entity.WaterCalculateEntity;
import io.renren.modules.sys.service.WaterCalculateService;


@Service("waterCalculateService")
public class WaterCalculateServiceImpl extends ServiceImpl<WaterCalculateDao, WaterCalculateEntity> implements WaterCalculateService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WaterCalculateEntity> page = this.page(
                new Query<WaterCalculateEntity>().getPage(params),
                new QueryWrapper<WaterCalculateEntity>()
        );

        return new PageUtils(page);
    }

}
