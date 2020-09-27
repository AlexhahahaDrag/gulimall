package com.alex.gulimall.coupon.service;

import com.alex.gulimall.common.utils.R;
import com.baomidou.mybatisplus.extension.service.IService;
import com.alex.gulimall.common.utils.PageUtils;
import com.alex.gulimall.coupon.entity.SmsCouponEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 优惠券信息
 *
 * @author alex
 * @email 734663446@qq.com
 * @date 2020-09-25 07:07:44
 */
public interface SmsCouponService extends IService<SmsCouponEntity> {

    PageUtils queryPage(Map<String, Object> params);

    R info();
}

