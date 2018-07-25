package com.amazon.module.controller;

import com.amazon.base.dto.BaseRequestDto;
import com.amazon.base.dto.BaseResponseDto;
import com.amazon.base.util.GenerateUtil;
import com.amazon.module.entity.Order;
import com.amazon.module.entity.User;
import com.amazon.module.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author 岸久
 * @version 1.0
 * @datetime 2018.7.24 19:44
 * @describe 该接口用于测试一些注解或方法的使用
 * */
@Api(description = "测试接口")
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private OrderService os;

    /**
     * @param session 会话对象
     * @datetime 2018.7.24 19:46
     * */
    @ApiOperation(value = "存储session属性值")
    @RequestMapping(value = "/saveSessionValue",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponseDto<User> saveSessionValue(HttpSession session){
        BaseResponseDto<User> baseResp=new BaseResponseDto<>();
        try{
            session.setAttribute("user_id","123123");
            baseResp.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            baseResp.setSuccess(false);
        }
        return baseResp;
    }

    /**
     * @param userId 存储的测试userId
     * @return 返回userId
     * @datetime 2018.7.24 19:49
     * */
    @ApiOperation(value = "取出session属性值")
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public  BaseResponseDto<String> register(@SessionAttribute("user_id") String userId){
        BaseResponseDto<String> baseResp=new BaseResponseDto<>();
        try{
            baseResp.setData(userId);
            baseResp.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            baseResp.setSuccess(false);
        }
        return baseResp;
    }

    /**
     * @datetime 2018.7.25 19:43
     * */
    @ApiOperation(value = "测试mybatis插入")
    @RequestMapping(value = "/insertOrderTest",method = RequestMethod.POST)
    @ResponseBody
    public  BaseResponseDto<String> insertOrderTest(){
        BaseResponseDto<String> baseResp=new BaseResponseDto<>();
        try{
            Order order=new Order();
            order.setOid(GenerateUtil.generateOrderId());
            order.setAddress("1111");
            order.setCost(6654.99);
            User user=new User();
            user.setUser_id("401484181D654F2FACF26AA0571C7D74");
            user.setUsername("1232321");
            order.setUser(user);
            os.placeOrder(order);
        }catch (Exception e){
            e.printStackTrace();
            baseResp.setSuccess(false);
        }
        return baseResp;
    }

}