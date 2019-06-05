package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.CommunityBuildingDao;
import io.renren.modules.sys.entity.CommunityBuildingEntity;
import io.renren.modules.sys.service.CommunityBuildingService;


@Service("communityBuildingService")
public class CommunityBuildingServiceImpl extends ServiceImpl<CommunityBuildingDao, CommunityBuildingEntity> implements CommunityBuildingService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CommunityBuildingEntity> page = this.page(
                new Query<CommunityBuildingEntity>().getPage(params),
                new QueryWrapper<CommunityBuildingEntity>()
        );

        return new PageUtils(page);
    }

}
