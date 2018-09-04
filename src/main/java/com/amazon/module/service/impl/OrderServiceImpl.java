package com.amazon.module.service.impl;

import com.amazon.module.dao.AddressDao;
import com.amazon.module.dao.OrderDao;
import com.amazon.module.dao.PlaceNameDao;
import com.amazon.module.dto.ParamsDto;
import com.amazon.module.entity.Address;
import com.amazon.module.entity.Order;
import com.amazon.module.entity.PlaceName;
import com.amazon.module.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDao od;
    @Autowired
    private PlaceNameDao pnd;
    @Autowired
    private AddressDao ad;
    public String placeOrder(Order order) {
        return od.addOrder(order);
    }

    @Override
    public List<PlaceName> getPlaceNameListByParentId(ParamsDto params) {
        return pnd.queryPlaceNameListByParentId(params.getParentId());
    }

    @Override
    public int saveNewAddress(Address address) {
        return ad.addNewAddress(address);
    }

    @Override
    public List<Address> getMyAddress(String user_id) {
        return ad.queryMyAddress(user_id);
    }

    @Override
    public boolean changeMyDefaultAddress(ParamsDto params){
        int i=ad.updateAddressStatusToNull(params);
        int j=ad.updateAddressStatusToDefault(params);
        if(j>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteMyAddress(ParamsDto params) {
        int i=ad.deleteMyAddressByAid(params);
        return false;
    }
}
