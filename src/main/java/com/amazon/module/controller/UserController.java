package com.amazon.module.controller;

import com.amazon.module.entity.User;
import com.amazon.module.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService us;

    @RequestMapping("/login")
    public ModelAndView login(User user){
        return null;
    }

    @RequestMapping("/register")
    public  String register(User user){
        User u=new User();
        u.setUsername("demo");
        u.setPassword("123");
        u.setBirthday(new Date());
        u.setId_code("320721199611110225");
        u.setEmail("123@123.com");
        u.setAddress("china");
        u.setMobile("110");
        u.setSex("m");
        us.registerUser(u);
        return "1";
    }

    @RequestMapping("/checkEmail")
    public String checkEmail(User user){
        return null;
    }

}
