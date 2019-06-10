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

import io.renren.modules.sys.entity.RechargeRecordEntity;
import io.renren.modules.sys.service.RechargeRecordService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 充值记录表
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-09 11:53:03
 */
@RestController
@RequestMapping("sys/rechargerecord")
public class RechargeRecordController {
    @Autowired
    private RechargeRecordService rechargeRecordService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:rechargerecord:list")
    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = rechargeRecordService.queryPage(params);
        PageUtils page = rechargeRecordService.queryCountPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:rechargerecord:info")
    public R info(@PathVariable("id") Integer id){
        RechargeRecordEntity rechargeRecord = rechargeRecordService.getById(id);

        return R.ok().put("rechargeRecord", rechargeRecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:rechargerecord:save")
    public R save(@RequestBody RechargeRecordEntity rechargeRecord){
        rechargeRecordService.save(rechargeRecord);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:rechargerecord:update")
    public R update(@RequestBody RechargeRecordEntity rechargeRecord){
        ValidatorUtils.validateEntity(rechargeRecord);
        rechargeRecordService.updateById(rechargeRecord);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:rechargerecord:delete")
    public R delete(@RequestBody Integer[] ids){
        rechargeRecordService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
