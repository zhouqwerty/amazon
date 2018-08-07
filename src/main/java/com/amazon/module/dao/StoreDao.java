package com.amazon.module.dao;

import com.amazon.module.entity.Store;
import com.amazon.module.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author 岸久
 * @version 1.0
 * @datetime 2018.8.7 20:29
 * @describe 该dao处理商铺表的操作
 * */
public interface StoreDao {


    /**
     * @function 通过商铺id查询商铺
     * @param sid 商铺id
     * @return 商铺信息
     * @datetime 2018.8.2 19:14
     * */
    Store queryStoreBySid(@Param("sid") String sid);
}
