package com.alex.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.alex.gulimall.common.utils.PageUtils;
import com.alex.gulimall.product.entity.ProductAttrValueEntity;

import java.util.Map;

/**
 * spu属性值
 *
 * @author alex
 * @email 734663446@qq.com
 * @date 2020-09-24 21:34:09
 */
public interface ProductAttrValueService extends IService<ProductAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

