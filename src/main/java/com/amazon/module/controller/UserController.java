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
/**
 * @author 岸久
 * @version 1.0
 * @datetime 2018.7.23 20:12
 * @describe 该接口用于处理关于用户信息的请求
 * */
@Api(description = "用户接口")
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService us;

    /**
     * @param user 登录所需的用户名和密码
     * @return 返回登录的查询结果 1 登录成功 0 登录失败
     * @datetime 2018.7.23 20:15
     * */
    @ApiOperation(value = "登录")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody User user){
        us.validUser(user);
        return "1";
    }

    /**
     * @param user 注册所需的信息
     * @return 返回注册结果 1 注册成功 0 注册失败
     * @datetime 2018.7.23 20:15
     * */
    @ApiOperation(value = "注册")
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public  String register(@RequestBody User user){
        us.registerUser(user);
        return "1";
    }

    @RequestMapping(value = "/checkEmail",method = RequestMethod.POST)
    @ResponseBody
    public String checkEmail(@RequestBody User user){
        return null;
    }

}
