package com.alex.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alex.gulimall.common.utils.PageUtils;
import com.alex.gulimall.common.utils.Query;

import com.alex.gulimall.product.dao.CategoryDao;
import com.alex.gulimall.product.entity.CategoryEntity;
import com.alex.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> selectGategoryTree() {
        QueryWrapper<CategoryEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("cat_id", "sort");
        List<CategoryEntity> entities = baseMapper.selectList(queryWrapper);
        Map<Long, List<CategoryEntity>> map = new HashMap<>();
        entities.forEach(categoryEntity -> {
            if (map.containsKey(categoryEntity.getParentCid())) {
                map.get(categoryEntity.getParentCid()).add(categoryEntity);
            } else {
                List<CategoryEntity> list = new ArrayList<>();
                list.add(categoryEntity);
                map.put(categoryEntity.getParentCid(), list);
            }
        });
        List<CategoryEntity> res = map.get(0L);
        if (res != null && res.size() > 0)
            for (CategoryEntity categoryEntity : res)
                findChildren(categoryEntity, map);
        return res;
    }

    private void findChildren(CategoryEntity categoryEntity, Map<Long, List<CategoryEntity>> map) {
        if (!map.containsKey(categoryEntity.getCatId()))
            return;
        List<CategoryEntity> list = map.get(categoryEntity.getCatId());
        categoryEntity.setChildren(list);
        for (CategoryEntity categoryEntity1 : list)
            findChildren(categoryEntity1, map);
    }
}