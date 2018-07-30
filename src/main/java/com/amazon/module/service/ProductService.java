package com.amazon.module.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author 岸久
 * @version 1.0
 * @datetime 2018.7.30 18:52
 * @describe 该service提供关于商品的服务
 * */
public interface ProductService {

    JSONArray getProductCategory();
}
