package com.amazon.module.dao;

import com.amazon.module.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductDao {

    /**
     * @param search 搜索模糊查询的商品数量
     * @return 商品数量
     * @datetime 2018.8.1 19:20
     * */
    Integer queryProductCountBySearch(@Param("search") String search);

    /**
     * @param paramMap 搜索模糊查询的商品
     * @return 商品(分页)
     * @datetime 2018.8.1 19:28
     * */
    List<Product> queryProductsBySearch(Map<String, Object> paramMap);

    /**
     * @param pcid 根据一级分类查询的商品数量
     * @return 商品数量
     * @datetime 2018.8.1 20:33
     * */
    Integer queryProductCountByPcid(@Param("cid") String pcid);

    /**
     * @param pcid 根据一级分类查询的商品
     * @return 商品(分页)
     * @datetime 2018.8.1 20:33
     * */
    List<Product> queryProductsByPcid(Map<String, Object> pcid);

    /**
     * @param cpcid 根据二级分类查询的商品数量
     * @return 商品数量
     * @datetime 2018.8.1 20:33
     * */
    Integer queryProductCountByCpcid(@Param("cid") String cpcid);

    /**
     * @param cpcid 根据二级分类查询的商品
     * @return 商品(分页)
     * @datetime 2018.8.1 20:33
     * */
    List<Product> queryProductsByCpcid(Map<String, Object> cpcid);
}
