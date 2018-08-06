package com.amazon.module.dao;

import com.amazon.module.entity.ProductCategory;
import java.util.List;


public interface ProductCategoryDao {
    /**
     * @function 根据父类id查询子类分类
     * @param pcid 分类id
     * @return 根据id查询出的子类分类
     * @datetime 2018.8.2 19:08
     * */
    List<ProductCategory> queryProductCategoryByParentId(String pcid);
}
