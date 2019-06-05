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

import io.renren.modules.sys.entity.WaterCalculateMonthsEntity;
import io.renren.modules.sys.service.WaterCalculateMonthsService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 月份表
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-05 01:55:52
 */
@RestController
@RequestMapping("sys/watercalculatemonths")
public class WaterCalculateMonthsController {
    @Autowired
    private WaterCalculateMonthsService waterCalculateMonthsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:watercalculatemonths:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = waterCalculateMonthsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:watercalculatemonths:info")
    public R info(@PathVariable("id") Integer id){
        WaterCalculateMonthsEntity waterCalculateMonths = waterCalculateMonthsService.getById(id);

        return R.ok().put("waterCalculateMonths", waterCalculateMonths);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:watercalculatemonths:save")
    public R save(@RequestBody WaterCalculateMonthsEntity waterCalculateMonths){
        waterCalculateMonthsService.save(waterCalculateMonths);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:watercalculatemonths:update")
    public R update(@RequestBody WaterCalculateMonthsEntity waterCalculateMonths){
        ValidatorUtils.validateEntity(waterCalculateMonths);
        waterCalculateMonthsService.updateById(waterCalculateMonths);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:watercalculatemonths:delete")
    public R delete(@RequestBody Integer[] ids){
        waterCalculateMonthsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
