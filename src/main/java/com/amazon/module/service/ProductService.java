package com.amazon.module.service;

import com.alibaba.fastjson.JSONArray;
import com.amazon.module.dto.ParamsDto;

import java.util.Map;

/**
 * @author 岸久
 * @version 1.0
 * @datetime 2018.7.30 18:52
 * @describe 该service提供关于商品的服务
 * */
public interface ProductService {

    /**
     * @function 获取商品分类目录树
     * @return 商品分类目录树
     * @datetime 2018.8.1 19:03
     * */
    JSONArray getProductCategory();

    /**
     * @function 根据输入内容模糊查询商品（分页）
     * @param params 通过搜索模糊查询商品
     * @return 商品集合（分页）
     * @datetime 2018.8.1 19:03
     * */
    Map<String, Object> getProductPageBySearch(ParamsDto params);

    /**
     * @function 根据分类查询商品（分页）
     * @param params 通过商品分类查询商品
     * @return 商品集合（分页）
     * @datetime 2018.8.1 19:03
     * */
    Map<String, Object> getProductPageByCategory(ParamsDto params);
}
