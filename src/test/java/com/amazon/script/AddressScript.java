package com.amazon.script;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.amazon.module.dao.PlaceNameDao;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.File;
import java.io.IOException;

/*
 * spring整合Junit4单元测试基类，
 * 其他类实现该类可以省略一些注解配置。
 * */
//使用junit4进行单元测试
@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//加载配置文件，可以指定多个配置文件，locations指定的是一个数组
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/applicationContext.xml", "classpath:spring/spring-mvc.xml"})
public class AddressScript {

    @Autowired
    private PlaceNameDao pnd;
    @Test
    public void insertPlaceName(){
        String path = getClass().getClassLoader().getResource("resource/address.json").toString();
        try {
            String str=FileUtils.readFileToString(new File(path.replace("file:/","")));
            JSONObject obj=JSONObject.parseObject(str);
            //开始插入
            JSONObject country=new JSONObject();
            country.put("name","中国");
            country.put("type","国");
            country.put("parent_id","");
            pnd.addPlaceName(country);
            String countryId=country.getString("pnId");
            for(Object pro:(JSONArray)obj.get("provinces")){
                JSONObject province=(JSONObject)pro;
                province.put("name",province.getString("provinceName"));
                province.put("type","省");
                province.put("parent_id",countryId);
                pnd.addPlaceName(province);
                String provinceId=province.getString("pnId");
                for(Object c:(JSONArray)province.get("citys")){
                    JSONObject city=(JSONObject)c;
                    city.put("name",city.getString("citysName"));
                    city.put("type","市");
                    city.put("parent_id",provinceId);
                    pnd.addPlaceName(city);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsertPlaceName(){
        JSONObject obj=new JSONObject();
        obj.put("pnId","sdasdsads");
        obj.put("name","11111");
        obj.put("type","jia");
        obj.put("parent_id","");
        System.out.println(pnd.addPlaceName(obj));
        System.out.println(obj.get("pnId"));
    }
}
