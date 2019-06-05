package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.UnitCommunityDao;
import io.renren.modules.sys.entity.UnitCommunityEntity;
import io.renren.modules.sys.service.UnitCommunityService;


@Service("unitCommunityService")
public class UnitCommunityServiceImpl extends ServiceImpl<UnitCommunityDao, UnitCommunityEntity> implements UnitCommunityService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UnitCommunityEntity> page = this.page(
                new Query<UnitCommunityEntity>().getPage(params),
                new QueryWrapper<UnitCommunityEntity>()
        );

        return new PageUtils(page);
    }

}
