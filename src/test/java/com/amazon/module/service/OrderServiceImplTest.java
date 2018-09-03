package com.amazon.module.service;

import com.amazon.base.BaseTestClass.BaseTestClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceImplTest extends BaseTestClass{
    @Autowired
    private OrderService os;

    @Test
    public void changeMyDefaultAddressTest() throws Exception{
//        os.changeMyDefaultAddress(null,"401484181D654F2FACF26AA0571C7D74");
    }

}
