package com.alex.gulimall.member.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alex.gulimall.common.utils.PageUtils;
import com.alex.gulimall.common.utils.Query;

import com.alex.gulimall.member.dao.UmsMemberCollectSpuDao;
import com.alex.gulimall.member.entity.UmsMemberCollectSpuEntity;
import com.alex.gulimall.member.service.UmsMemberCollectSpuService;


@Service("umsMemberCollectSpuService")
public class UmsMemberCollectSpuServiceImpl extends ServiceImpl<UmsMemberCollectSpuDao, UmsMemberCollectSpuEntity> implements UmsMemberCollectSpuService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsMemberCollectSpuEntity> page = this.page(
                new Query<UmsMemberCollectSpuEntity>().getPage(params),
                new QueryWrapper<UmsMemberCollectSpuEntity>()
        );

        return new PageUtils(page);
    }

}