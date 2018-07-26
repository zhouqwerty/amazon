package com.amazon.base.util;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author 岸久
 * @version 1.0
 * @datetime 2018.7.24 20:21
 * @describe 工具类 用于生成一些数据(随机数，id等)
 * */
public class GenerateUtil {

    private static SimpleDateFormat sdf1=new SimpleDateFormat("yyyyMMddHHmmssSSSS");
    private static ThreadLocalRandom random=ThreadLocalRandom.current();

    public static String generateOrderId(){
        StringBuffer buffer=new StringBuffer();
        buffer.append(sdf1.format(new Date()));
        buffer.append(numToStringLen4(random.nextInt(10000)));
        return buffer.toString();
    }

    public static String generateTokeCode(){
        String value = System.currentTimeMillis()+new Random().nextInt()+"";
        //获取数据指纹，指纹是唯一的
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] b = md.digest(value.getBytes());//产生数据的指纹
            //Base64编码
            BASE64Encoder be = new BASE64Encoder();
            be.encode(b);
            return be.encode(b);//制定一个编码
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String numToStringLen4(int num){
        String result=null;
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
        return result;
    }

}
