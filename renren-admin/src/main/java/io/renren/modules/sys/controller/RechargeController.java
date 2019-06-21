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

import io.renren.modules.sys.entity.RechargeEntity;
import io.renren.modules.sys.service.RechargeService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 余额表
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-11 00:36:15
 */
@RestController
@RequestMapping("sys/recharge")
public class RechargeController  extends AbstractController{
    @Autowired
    private RechargeService rechargeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:recharge:list")
    public R list(@RequestParam Map<String, Object> params){
        params.put(USER_ID_KEY,getUserId());
        PageUtils page = rechargeService.queryCountPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:recharge:info")
    public R info(@PathVariable("id") Integer id){
        RechargeEntity recharge = rechargeService.getById(id);

        return R.ok().put("recharge", recharge);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:recharge:save")
    public R save(@RequestBody RechargeEntity recharge){
        rechargeService.save(recharge);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:recharge:update")
    public R update(@RequestBody RechargeEntity recharge){
        ValidatorUtils.validateEntity(recharge);
        rechargeService.updateById(recharge);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:recharge:delete")
    public R delete(@RequestBody Integer[] ids){
        rechargeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
