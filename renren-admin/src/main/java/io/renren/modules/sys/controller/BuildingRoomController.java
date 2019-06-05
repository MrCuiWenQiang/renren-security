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

import io.renren.modules.sys.entity.BuildingRoomEntity;
import io.renren.modules.sys.service.BuildingRoomService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 单元房间号
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-05 01:55:52
 */
@RestController
@RequestMapping("sys/buildingroom")
public class BuildingRoomController {
    @Autowired
    private BuildingRoomService buildingRoomService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:buildingroom:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = buildingRoomService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:buildingroom:info")
    public R info(@PathVariable("id") Integer id){
        BuildingRoomEntity buildingRoom = buildingRoomService.getById(id);

        return R.ok().put("buildingRoom", buildingRoom);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:buildingroom:save")
    public R save(@RequestBody BuildingRoomEntity buildingRoom){
        buildingRoomService.save(buildingRoom);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:buildingroom:update")
    public R update(@RequestBody BuildingRoomEntity buildingRoom){
        ValidatorUtils.validateEntity(buildingRoom);
        buildingRoomService.updateById(buildingRoom);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:buildingroom:delete")
    public R delete(@RequestBody Integer[] ids){
        buildingRoomService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
