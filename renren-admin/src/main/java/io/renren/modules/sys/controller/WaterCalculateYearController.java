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

import io.renren.modules.sys.entity.WaterCalculateYearEntity;
import io.renren.modules.sys.service.WaterCalculateYearService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 年份表
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-05 01:55:52
 */
@RestController
@RequestMapping("sys/watercalculateyear")
public class WaterCalculateYearController {
    @Autowired
    private WaterCalculateYearService waterCalculateYearService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:watercalculateyear:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = waterCalculateYearService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:watercalculateyear:info")
    public R info(@PathVariable("id") Integer id){
        WaterCalculateYearEntity waterCalculateYear = waterCalculateYearService.getById(id);

        return R.ok().put("waterCalculateYear", waterCalculateYear);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:watercalculateyear:save")
    public R save(@RequestBody WaterCalculateYearEntity waterCalculateYear){
        waterCalculateYearService.save(waterCalculateYear);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:watercalculateyear:update")
    public R update(@RequestBody WaterCalculateYearEntity waterCalculateYear){
        ValidatorUtils.validateEntity(waterCalculateYear);
        waterCalculateYearService.updateById(waterCalculateYear);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:watercalculateyear:delete")
    public R delete(@RequestBody Integer[] ids){
        waterCalculateYearService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
