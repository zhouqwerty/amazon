package com.amazon.base.util;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class GenerateUtilTest {
    private SimpleDateFormat sdf1=new SimpleDateFormat("yyyyMMddHHmmssSSSS");
    private Random random=new Random();

    @Test
    public void testFormat(){
        System.out.println(sdf1.format(new Date()));
    }

    @Test
    public void randomTest(){
        System.out.println(random.nextInt(1));
    }

    @Test
    public void subStringTest(){
        System.out.println("123456".substring(0,4));
    }

    @Test
    public void testNumToStringLen4(){
        String result=null;
        int num=10000;
        if(num<10000){
            if(num<10){
                result="000"+num;
            }else if(num<100){
                result="00"+num;
            }else if(num<1000){
                result="0"+num;
            }else{
                result=""+num;
            }
        }else{
            result=(num+"").substring(0,4);
        }
        System.out.println(result);
    }

    @Test
    public void testGenerateOrderId(){
        System.out.println(GenerateUtil.generateOrderId());
    }

}
