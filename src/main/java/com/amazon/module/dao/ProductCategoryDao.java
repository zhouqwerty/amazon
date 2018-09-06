package com.amazon.module.dao;

import com.amazon.module.entity.ProductCategory;
import com.amazon.module.entity.Store;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 岸久
 * @version 1.0
 * @datetime 2018.8.12 16:46
 * @describe 该dao处理商品分类表的操作
 * */
public interface ProductCategoryDao {
    /**
     * @function 通过商品分类id查询商品分类
     * @param pcid 商品分类id
     * @return 商品分类
     * @datetime 2018.9.6 19:30
     * */
    ProductCategory queryProductCategoryByPcid(@Param("pcid") String pcid);

    /**
     * @function 根据父类id查询子类分类
     * @param pcid 分类id
     * @return 根据id查询出的子类分类
     * @datetime 2018.8.2 19:08
     * */
    List<ProductCategory> queryProductCategoryByParentId(String pcid);
}
