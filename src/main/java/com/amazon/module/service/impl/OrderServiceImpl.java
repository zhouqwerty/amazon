package com.amazon.module.service.impl;

import com.amazon.module.dao.OrderDao;
import com.amazon.module.entity.Order;
import com.amazon.module.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDao od;
    public String placeOrder(Order order) {
        return od.addOrder(order);
    }
}
