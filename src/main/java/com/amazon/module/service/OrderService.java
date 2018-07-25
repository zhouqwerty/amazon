package com.amazon.module.service;

import com.amazon.module.entity.Order;

/**
 * @author 岸久
 * @version 1.0
 * @datetime 2018.7.23 20:21
 * @describe 该service提供关于订单的服务
 * */
public interface OrderService {
    String placeOrder(Order order);
}
