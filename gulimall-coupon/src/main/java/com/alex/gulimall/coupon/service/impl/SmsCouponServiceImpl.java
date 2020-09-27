package com.alex.gulimall.coupon.service.impl;

import com.alex.gulimall.common.utils.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alex.gulimall.common.utils.PageUtils;
import com.alex.gulimall.common.utils.Query;

import com.alex.gulimall.coupon.dao.SmsCouponDao;
import com.alex.gulimall.coupon.entity.SmsCouponEntity;
import com.alex.gulimall.coupon.service.SmsCouponService;


@Service("smsCouponService")
public class SmsCouponServiceImpl extends ServiceImpl<SmsCouponDao, SmsCouponEntity> implements SmsCouponService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SmsCouponEntity> page = this.page(
                new Query<SmsCouponEntity>().getPage(params),
                new QueryWrapper<SmsCouponEntity>()
        );

        return new PageUtils(page);
    }

    @Value("${coupon.version}")
    private String version;

    @Override
    public R info() {
        return R.ok().put("version", version);
    }
}