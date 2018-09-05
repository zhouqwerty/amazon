package com.amazon.module.service;

import com.amazon.base.BaseTestClass.BaseTestClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceImplTest extends BaseTestClass{


    @Test
    public void splitTest() throws Exception{
        String[] str="2132112dqa".split("|");
        System.out.println(str);

    }

}
