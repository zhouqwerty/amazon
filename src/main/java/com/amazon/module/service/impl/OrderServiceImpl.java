package com.amazon.module.service.impl;

import com.amazon.module.dao.OrderDao;
import com.amazon.module.dao.PlaceNameDao;
import com.amazon.module.dto.ParamsDto;
import com.amazon.module.entity.Order;
import com.amazon.module.entity.PlaceName;
import com.amazon.module.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDao od;
    @Autowired
    private PlaceNameDao pnd;
    public String placeOrder(Order order) {
        return od.addOrder(order);
    }

    @Override
    public List<PlaceName> getPlaceNameListByParentId(ParamsDto params) {
        return pnd.queryPlaceNameListByParentId(params.getParentId());
    }
}
