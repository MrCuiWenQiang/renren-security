package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.WaterCalculateDateDao;
import io.renren.modules.sys.entity.WaterCalculateDateEntity;
import io.renren.modules.sys.service.WaterCalculateDateService;


@Service("waterCalculateDateService")
public class WaterCalculateDateServiceImpl extends ServiceImpl<WaterCalculateDateDao, WaterCalculateDateEntity> implements WaterCalculateDateService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WaterCalculateDateEntity> page = this.page(
                new Query<WaterCalculateDateEntity>().getPage(params),
                new QueryWrapper<WaterCalculateDateEntity>()
        );

        return new PageUtils(page);
    }

}
