package io.renren.modules.sys.service.impl;

import io.renren.common.utils.Constant;
import io.renren.modules.sys.entity.RechargeListEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.RechargeDao;
import io.renren.modules.sys.entity.RechargeEntity;
import io.renren.modules.sys.service.RechargeService;


@Service("rechargeService")
public class RechargeServiceImpl extends ServiceImpl<RechargeDao, RechargeEntity> implements RechargeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RechargeEntity> page = this.page(
                new Query<RechargeEntity>().getPage(params),
                new QueryWrapper<RechargeEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryCountPage(Map<String, Object> params) {
        //分页参数
        int curPage = 1;
        int limit = 10;
        int totalCount = 0;
        if (params.get(Constant.PAGE) != null) {
            curPage = Integer.valueOf((String) params.get(Constant.PAGE));
        }
        if (params.get(Constant.LIMIT) != null) {
            limit = Integer.valueOf((String) params.get(Constant.LIMIT));
        }
        int offset=(curPage - 1) * limit;
        params.put("offset",offset);
        List<RechargeListEntity> datas = baseMapper.queryComList(params);
        if (datas != null && datas.size() > 0) {
            totalCount = datas.get(0).getTotalCount();
        }

        return new PageUtils(datas, totalCount, limit,curPage);
    }

}
