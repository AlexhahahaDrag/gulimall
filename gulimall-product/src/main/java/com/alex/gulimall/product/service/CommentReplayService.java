package com.alex.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.alex.gulimall.common.utils.PageUtils;
import com.alex.gulimall.product.entity.CommentReplayEntity;

import java.util.Map;

/**
 * 商品评价回复关系
 *
 * @author alex
 * @email 734663446@qq.com
 * @date 2020-09-24 21:34:09
 */
public interface CommentReplayService extends IService<CommentReplayEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

