package com.amazon.module.dao;

import com.amazon.module.entity.Order;

/**
 * @author 岸久
 * @version 1.0
 * @datetime 2018.7.23 20:25
 * @describe 该dao处理订单表的操作
 * */
public interface OrderDao {
    String addOrder(Order order);
}
