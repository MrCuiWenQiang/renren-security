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

import io.renren.modules.sys.entity.WaterCalculateDayEntity;
import io.renren.modules.sys.service.WaterCalculateDayService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 日份表
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-05 01:55:52
 */
@RestController
@RequestMapping("sys/watercalculateday")
public class WaterCalculateDayController {
    @Autowired
    private WaterCalculateDayService waterCalculateDayService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:watercalculateday:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = waterCalculateDayService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:watercalculateday:info")
    public R info(@PathVariable("id") Integer id){
        WaterCalculateDayEntity waterCalculateDay = waterCalculateDayService.getById(id);

        return R.ok().put("waterCalculateDay", waterCalculateDay);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:watercalculateday:save")
    public R save(@RequestBody WaterCalculateDayEntity waterCalculateDay){
        waterCalculateDayService.save(waterCalculateDay);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:watercalculateday:update")
    public R update(@RequestBody WaterCalculateDayEntity waterCalculateDay){
        ValidatorUtils.validateEntity(waterCalculateDay);
        waterCalculateDayService.updateById(waterCalculateDay);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:watercalculateday:delete")
    public R delete(@RequestBody Integer[] ids){
        waterCalculateDayService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
