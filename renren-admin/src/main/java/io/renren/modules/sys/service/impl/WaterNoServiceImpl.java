package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.WaterNoDao;
import io.renren.modules.sys.entity.WaterNoEntity;
import io.renren.modules.sys.service.WaterNoService;


@Service("waterNoService")
public class WaterNoServiceImpl extends ServiceImpl<WaterNoDao, WaterNoEntity> implements WaterNoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WaterNoEntity> page = this.page(
                new Query<WaterNoEntity>().getPage(params),
                new QueryWrapper<WaterNoEntity>()
        );

        return new PageUtils(page);
    }

}
