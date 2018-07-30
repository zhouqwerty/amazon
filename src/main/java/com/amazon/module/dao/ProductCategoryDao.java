package com.amazon.module.dao;

import com.amazon.module.entity.ProductCategory;
import java.util.List;


public interface ProductCategoryDao {
    List<ProductCategory> queryProductCategory(String pcid);

    List<ProductCategory> queryProductCategoryByParentId(String pcid);
}
