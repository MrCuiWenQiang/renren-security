package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.entity.UnitCommunityEntity;
import io.renren.modules.sys.service.UnitCommunityService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 小区号
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-05 01:55:52
 */
@RestController
@RequestMapping("sys/unitcommunity")
public class UnitCommunityController extends AbstractController{
    @Autowired
    private UnitCommunityService unitCommunityService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:unitcommunity:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = unitCommunityService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:unitcommunity:info")
    public R info(@PathVariable("id") Integer id){
        UnitCommunityEntity unitCommunity = unitCommunityService.getById(id);

        return R.ok().put("unitCommunity", unitCommunity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:unitcommunity:save")
    public R save(@RequestBody UnitCommunityEntity unitCommunity){
        unitCommunity.setUserId(getUserId());
        unitCommunityService.save(unitCommunity);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:unitcommunity:update")
    public R update(@RequestBody UnitCommunityEntity unitCommunity){
        ValidatorUtils.validateEntity(unitCommunity);
        unitCommunityService.updateById(unitCommunity);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:unitcommunity:delete")
    public R delete(@RequestBody Integer[] ids){
        unitCommunityService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
