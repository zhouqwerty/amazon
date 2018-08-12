package com.amazon.base.BaseTestClass;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

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
public class BaseTestClass {
}
