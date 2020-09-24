package com.alex.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.alex.gulimall.common.utils.PageUtils;
import com.alex.gulimall.product.entity.AttrAttrgroupRelationEntity;

import java.util.Map;

/**
 * 属性&属性分组关联
 *
 * @author alex
 * @email 734663446@qq.com
 * @date 2020-09-24 21:34:09
 */
public interface AttrAttrgroupRelationService extends IService<AttrAttrgroupRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

