package com.amazon.module.dao;

import com.amazon.module.entity.ProductCategory;
import java.util.List;

/**
 * @author 岸久
 * @version 1.0
 * @datetime 2018.8.12 16:46
 * @describe 该dao处理商品分类表的操作
 * */
public interface ProductCategoryDao {
    /**
     * @function 根据父类id查询子类分类
     * @param pcid 分类id
     * @return 根据id查询出的子类分类
     * @datetime 2018.8.2 19:08
     * */
    List<ProductCategory> queryProductCategoryByParentId(String pcid);
}
