package com.alex.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.alex.gulimall.common.utils.PageUtils;
import com.alex.gulimall.product.entity.SpuCommentEntity;

import java.util.Map;

/**
 * 商品评价
 *
 * @author alex
 * @email 734663446@qq.com
 * @date 2020-09-24 21:34:09
 */
public interface SpuCommentService extends IService<SpuCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

