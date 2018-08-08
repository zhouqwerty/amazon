package com.amazon.module.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;

/**
 * @author 岸久
 * @version 1.0
 * @datetime 2018.8.8 20:18
 * @describe 该dao处理地名表的操作
 * */
public interface PlaceNameDao {
    /**
     * @function 添加地名
     * @param placeName 地名
     * @return 插入的地名id
     * @datetime 2018.8.8 20.19
     * */
    String addPlaceName(JSONObject placeName);

    /**
     * @function 根据地名id查找地名
     * @param pnId 地名id
     * @return 插入的地名id
     * @datetime 2018.8.8 20.19
     * */
    String selectPlaceNameByPnId(@Param("pnId") String pnId);
}
