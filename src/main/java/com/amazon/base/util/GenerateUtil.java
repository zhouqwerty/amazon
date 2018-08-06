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

    /**
     * @function 产生订单id
     * @return 产生的订单id 当前时间+随机四位数
     * @datetime 2018.8.2 19:00
     * */
    public static String generateOrderId(){
        StringBuffer buffer=new StringBuffer();
        buffer.append(sdf1.format(new Date()));
        buffer.append(numToStringLen4(random.nextInt(10000)));
        return buffer.toString();
    }

    /**
     * @function 产生token id
     * @return 产生的token id
     * @datetime 2018.8.2 19:00
     * */
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

    /**
     * @function 将0-9999的数字转出长度为4的字符串
     * @param num 数字(0-9999)
     * @return 转成长度为4的字符串
     * @datetime 2018.8.2 19:00
     * */
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
