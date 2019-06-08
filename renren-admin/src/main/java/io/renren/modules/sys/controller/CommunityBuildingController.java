package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.entity.CommunityBuildingEntity;
import io.renren.modules.sys.service.CommunityBuildingService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 楼号
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-05 01:55:52
 */
@RestController
@RequestMapping("sys/communitybuilding")
public class CommunityBuildingController extends AbstractController{
    @Autowired
    private CommunityBuildingService communityBuildingService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:communitybuilding:list")
    public R list(@RequestParam Map<String, Object> params){
        params.put(USER_ID_KEY,getUserId());
        PageUtils page = communityBuildingService.queryCountPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:communitybuilding:info")
    public R info(@PathVariable("id") Integer id){
        CommunityBuildingEntity communityBuilding = communityBuildingService.getById(id);

        return R.ok().put("communityBuilding", communityBuilding);
    }

    @RequestMapping("/query/{id}")
    @RequiresPermissions("sys:communitybuilding:info")
    public R query(@PathVariable("id") Integer id){
        List<CommunityBuildingEntity> data = communityBuildingService.queryListByComId(id);

        return R.ok().put("list", data);
    }
    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:communitybuilding:save")
    public R save(@RequestBody CommunityBuildingEntity communityBuilding){
        communityBuildingService.save(communityBuilding);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:communitybuilding:update")
    public R update(@RequestBody CommunityBuildingEntity communityBuilding){
        ValidatorUtils.validateEntity(communityBuilding);
        communityBuildingService.updateById(communityBuilding);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:communitybuilding:delete")
    public R delete(@RequestBody Integer[] ids){
        communityBuildingService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
