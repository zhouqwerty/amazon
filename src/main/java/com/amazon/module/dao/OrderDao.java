package com.amazon.module.dao;

import com.amazon.module.entity.Order;

/**
 * @author 岸久
 * @version 1.0
 * @datetime 2018.7.23 20:25
 * @describe 该dao处理订单表的操作
 * */
public interface OrderDao {
    /**
     * @function 添加订单
     * @param order 订单信息
     * @return 插入的行数
     * @datetime 2018.8.2 19:08
     * */
    String addOrder(Order order);
}
