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

import io.renren.modules.sys.entity.WaterNoEntity;
import io.renren.modules.sys.service.WaterNoService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 给水号表
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-05 01:55:52
 */
@RestController
@RequestMapping("sys/waterno")
public class WaterNoController {
    @Autowired
    private WaterNoService waterNoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:waterno:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = waterNoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:waterno:info")
    public R info(@PathVariable("id") Integer id){
        WaterNoEntity waterNo = waterNoService.getById(id);

        return R.ok().put("waterNo", waterNo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:waterno:save")
    public R save(@RequestBody WaterNoEntity waterNo){
        waterNoService.save(waterNo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:waterno:update")
    public R update(@RequestBody WaterNoEntity waterNo){
        ValidatorUtils.validateEntity(waterNo);
        waterNoService.updateById(waterNo);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:waterno:delete")
    public R delete(@RequestBody Integer[] ids){
        waterNoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
