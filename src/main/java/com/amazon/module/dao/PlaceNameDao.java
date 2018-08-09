package com.amazon.module.dao;

import com.alibaba.fastjson.JSONObject;
import com.amazon.module.entity.PlaceName;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
    int addPlaceName(JSONObject placeName);

    /**
     * @function 获取地名集合
     * @param parentId 所需的父类id
     * @return 地名集合
     * @datetime 2018.8.9 20:00
     * */
    List<PlaceName> queryPlaceNameListByParentId(@Param("parentId") String parentId);
}
