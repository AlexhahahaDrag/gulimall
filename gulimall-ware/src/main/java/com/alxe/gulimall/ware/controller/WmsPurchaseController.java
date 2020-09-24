package com.alex.gulimall.ware.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alex.gulimall.ware.entity.WmsPurchaseEntity;
import com.alex.gulimall.ware.service.WmsPurchaseService;
import com.alex.gulimall.common.utils.PageUtils;
import com.alex.gulimall.common.utils.R;



/**
 * 采购信息
 *
 * @author alex
 * @email 734663446@qq.com
 * @date 2020-09-25 07:09:21
 */
@RestController
@RequestMapping("ware/wmspurchase")
public class WmsPurchaseController {
    @Autowired
    private WmsPurchaseService wmsPurchaseService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:wmspurchase:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = wmsPurchaseService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:wmspurchase:info")
    public R info(@PathVariable("id") Long id){
		WmsPurchaseEntity wmsPurchase = wmsPurchaseService.getById(id);

        return R.ok().put("wmsPurchase", wmsPurchase);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:wmspurchase:save")
    public R save(@RequestBody WmsPurchaseEntity wmsPurchase){
		wmsPurchaseService.save(wmsPurchase);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:wmspurchase:update")
    public R update(@RequestBody WmsPurchaseEntity wmsPurchase){
		wmsPurchaseService.updateById(wmsPurchase);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:wmspurchase:delete")
    public R delete(@RequestBody Long[] ids){
		wmsPurchaseService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
