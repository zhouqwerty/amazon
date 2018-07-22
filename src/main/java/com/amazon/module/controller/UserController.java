package com.amazon.module.controller;

import com.amazon.module.entity.User;
import com.amazon.module.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;

@Api(description = "用户接口")
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService us;
    @ApiOperation(value = "登录")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody User user){
        return "1";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public  String register(@RequestBody User user){
        User u=new User();
        u.setUsername("demo");
        u.setPassword("123");
        u.setBirthday(new Date());
        u.setId_code("320721199611110225");
        u.setEmail("123@123.com");
        u.setAddress("china");
        u.setMobile("110");
        u.setSex("1");
        us.registerUser(u);
        return "1";
    }

    @RequestMapping(value = "/checkEmail",method = RequestMethod.POST)
    @ResponseBody
    public String checkEmail(@RequestBody User user){
        return null;
    }

}
