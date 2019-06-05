package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.BuildingRoomDao;
import io.renren.modules.sys.entity.BuildingRoomEntity;
import io.renren.modules.sys.service.BuildingRoomService;


@Service("buildingRoomService")
public class BuildingRoomServiceImpl extends ServiceImpl<BuildingRoomDao, BuildingRoomEntity> implements BuildingRoomService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BuildingRoomEntity> page = this.page(
                new Query<BuildingRoomEntity>().getPage(params),
                new QueryWrapper<BuildingRoomEntity>()
        );

        return new PageUtils(page);
    }

}
