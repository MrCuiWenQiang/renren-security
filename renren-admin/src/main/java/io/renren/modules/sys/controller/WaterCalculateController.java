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

import io.renren.modules.sys.entity.WaterCalculateEntity;
import io.renren.modules.sys.service.WaterCalculateService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 计量表
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-05 01:55:52
 */
@RestController
@RequestMapping("sys/watercalculate")
public class WaterCalculateController {
    @Autowired
    private WaterCalculateService waterCalculateService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:watercalculate:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = waterCalculateService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:watercalculate:info")
    public R info(@PathVariable("id") Integer id){
        WaterCalculateEntity waterCalculate = waterCalculateService.getById(id);

        return R.ok().put("waterCalculate", waterCalculate);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:watercalculate:save")
    public R save(@RequestBody WaterCalculateEntity waterCalculate){
        waterCalculateService.save(waterCalculate);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:watercalculate:update")
    public R update(@RequestBody WaterCalculateEntity waterCalculate){
        ValidatorUtils.validateEntity(waterCalculate);
        waterCalculateService.updateById(waterCalculate);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:watercalculate:delete")
    public R delete(@RequestBody Integer[] ids){
        waterCalculateService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
