package com.alex.gulimall.coupon.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alex.gulimall.common.utils.PageUtils;
import com.alex.gulimall.common.utils.Query;

import com.alex.gulimall.coupon.dao.SmsHomeSubjectDao;
import com.alex.gulimall.coupon.entity.SmsHomeSubjectEntity;
import com.alex.gulimall.coupon.service.SmsHomeSubjectService;


@Service("smsHomeSubjectService")
public class SmsHomeSubjectServiceImpl extends ServiceImpl<SmsHomeSubjectDao, SmsHomeSubjectEntity> implements SmsHomeSubjectService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SmsHomeSubjectEntity> page = this.page(
                new Query<SmsHomeSubjectEntity>().getPage(params),
                new QueryWrapper<SmsHomeSubjectEntity>()
        );

        return new PageUtils(page);
    }

}