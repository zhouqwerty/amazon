package com.amazon.module.controller;

import com.amazon.base.dto.BaseRequestDto;
import com.amazon.base.dto.BaseResponseDto;
import com.amazon.base.util.CommonUtil;
import com.amazon.base.util.GenerateUtil;
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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
     * @param baseReq 登录所需的用户名和密码
     * @return 返回登录的查询结果
     * @datetime 2018.7.23 20:15
     * */
    @ApiOperation(value = "登录")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponseDto<User> login(@RequestBody BaseRequestDto<User> baseReq, HttpServletResponse resp, HttpSession session){
        BaseResponseDto<User> baseResp=new BaseResponseDto<>();
        baseResp.setTime(baseReq.getTime());
        try{
            User params=baseReq.getData();
            User result=us.validUser(params);
            if(!CommonUtil.isNullOrEmpty(result)){
                String token=GenerateUtil.generateTokeCode();
                session.setAttribute("token", token);
                resp.addCookie(new Cookie("token",token));
            }
            baseResp.setData(result);
            baseResp.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            baseResp.setSuccess(false);
        }
        return baseResp;
    }

    /**
     * @param baseReq 注册所需的信息
     * @return 返回注册结果 1 注册成功 0 注册失败
     * @datetime 2018.7.23 20:15
     * */
    @ApiOperation(value = "注册")
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public  BaseResponseDto<String> register(@RequestBody BaseRequestDto<User> baseReq){
        BaseResponseDto<String> baseResp=new BaseResponseDto<>();
        baseResp.setTime(baseReq.getTime());
        try{
            User user=baseReq.getData();
            int i=us.registerUser(user);
            baseResp.setData(i+"");
            baseResp.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            baseResp.setSuccess(false);
        }
        return baseResp;
    }

    @RequestMapping(value = "/checkEmail",method = RequestMethod.POST)
    @ResponseBody
    public String checkEmail(@RequestBody User user){
        return null;
    }

}
