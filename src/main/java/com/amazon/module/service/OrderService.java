package com.amazon.module.service;

import com.amazon.module.dto.ParamsDto;
import com.amazon.module.entity.Address;
import com.amazon.module.entity.Order;
import com.amazon.module.entity.PlaceName;

import java.util.List;

/**
 * @author 岸久
 * @version 1.0
 * @datetime 2018.7.23 20:21
 * @describe 该service提供关于订单的服务
 * */
public interface OrderService {
    /**
     * @function 下订单
     * @param order 订单信息
     * @return 插入的行数
     * @datetime 2018.8.2 19:16
     * */
    String placeOrder(Order order);

    /**
     * @function 获取地名集合
     * @param params 所需的父类id
     * @return 地名集合
     * @datetime 2018.8.9 20:00
     * */
    List<PlaceName> getPlaceNameListByParentId(ParamsDto params);

    /**
     * @function 存储新的地址
     * @param address 新地址信息
     * @return 操作结果
     * @datetime 2018.8.12 16:44
     * */
    int saveNewAddress(Address address);

    /**
     * @function 获取我的所有地址
     * @param user_id 用户id
     * @return 当前用户的所有地址
     * @datetime 2018.8.12 17:56
     * */
    List<Address> getMyAddress(String user_id);

    /**
     * @function 改变用户的默认地址
     * @param params 要设置成默认地址的地址id和user_id
     * @return 更新结果
     * @datetime 2018.8.12 19:26
     * */
    boolean changeMyDefaultAddress(ParamsDto params);
}
