package com.amazon.base.controller;

import com.amazon.base.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public ModelAndView login(User user){
        return null;
    }

    @RequestMapping("/register")
    public  ModelAndView register(User user){
        return null;
    }

    @RequestMapping("/checkEmail")
    public String checkEmail(User user){
        return null;
    }
}
