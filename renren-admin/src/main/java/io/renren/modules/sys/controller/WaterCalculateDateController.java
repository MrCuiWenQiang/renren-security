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

import io.renren.modules.sys.entity.WaterCalculateDateEntity;
import io.renren.modules.sys.service.WaterCalculateDateService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 时刻表
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-05 01:55:52
 */
@RestController
@RequestMapping("sys/watercalculatedate")
public class WaterCalculateDateController {
    @Autowired
    private WaterCalculateDateService waterCalculateDateService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:watercalculatedate:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = waterCalculateDateService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:watercalculatedate:info")
    public R info(@PathVariable("id") Integer id){
        WaterCalculateDateEntity waterCalculateDate = waterCalculateDateService.getById(id);

        return R.ok().put("waterCalculateDate", waterCalculateDate);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:watercalculatedate:save")
    public R save(@RequestBody WaterCalculateDateEntity waterCalculateDate){
        waterCalculateDateService.save(waterCalculateDate);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:watercalculatedate:update")
    public R update(@RequestBody WaterCalculateDateEntity waterCalculateDate){
        ValidatorUtils.validateEntity(waterCalculateDate);
        waterCalculateDateService.updateById(waterCalculateDate);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:watercalculatedate:delete")
    public R delete(@RequestBody Integer[] ids){
        waterCalculateDateService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
