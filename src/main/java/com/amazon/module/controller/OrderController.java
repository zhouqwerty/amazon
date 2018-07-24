package com.amazon.module.controller;

import com.amazon.base.dto.BaseRequestDto;
import com.amazon.base.dto.BaseResponseDto;
import com.amazon.module.entity.Order;
import com.amazon.module.entity.User;
import com.amazon.module.service.OrderService;
import com.amazon.module.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author 岸久
 * @version 1.0
 * @datetime 2018.7.23 20:16
 * @describe 该接口用于处理关于订单信息的请求
 * */
@Api(description = "订单接口")
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService os;

    /**
     * @param baseReq 下订单所需的信息
     * @return 返回下订单的结果 1 下订单成功 0 下订单失败
     * @datetime 2018.7.23 20:17
     * */
    @ApiOperation(value = "下订单")
    @RequestMapping(value = "/placeOrder",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponseDto<String> placeOrder(@RequestBody BaseRequestDto<Order> baseReq, @SessionAttribute("user") User user){
        BaseResponseDto<String> baseResp=new BaseResponseDto<>();
        baseResp.setTime(baseReq.getTime());
        try{
            Order order=baseReq.getData();
            order.setUser(user);
            os.placeOrder(order);
            baseResp.setData("");
            baseResp.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            baseResp.setSuccess(false);
        }
        return baseResp;
    }
}
