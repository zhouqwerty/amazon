package com.amazon.module.dao;

import com.amazon.module.dto.ParamsDto;
import com.amazon.module.entity.Product;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface ProductDao {

    /**
     * @function 通过搜索模糊查询商品的数量
     * @param search 搜索内容
     * @return 商品数量
     * @datetime 2018.8.1 19:20
     * */
    Integer queryProductCountBySearch(@Param("search") String search);

    /**
     * @function 通过搜索模糊查询商品
     * @param paramMap 搜索内容
     * @return 商品(分页)
     * @datetime 2018.8.1 19:28
     * */
    List<Product> queryProductsBySearch(Map<String, Object> paramMap);

    /**
     * @function 根据一级分类查询的商品数量
     * @param pcid 一级分类id
     * @return 商品数量
     * @datetime 2018.8.1 20:33
     * */
    Integer queryProductCountByPcid(@Param("cid") String pcid);

    /**
     * @function 根据一级分类查询的商品
     * @param pcid 一级分类id
     * @return 商品(分页)
     * @datetime 2018.8.1 20:33
     * */
    List<Product> queryProductsByPcid(Map<String, Object> pcid);

    /**
     * @function 根据二级分类查询的商品数量
     * @param cpcid 二级分类id
     * @return 商品数量
     * @datetime 2018.8.1 20:33
     * */
    Integer queryProductCountByCpcid(@Param("cid") String cpcid);

    /**
     * @function 根据二级分类查询的商品
     * @param cpcid 二级分类id
     * @return 商品(分页)
     * @datetime 2018.8.1 20:33
     * */
    List<Product> queryProductsByCpcid(Map<String, Object> cpcid);

    /**
     * @function 根据商品id查询商品信息
     * @param params 商品id
     * @return 商品信息
     * @datetime 2018.8.7 20:28
     * */
    Product queryProductByPid(ParamsDto params);
}
