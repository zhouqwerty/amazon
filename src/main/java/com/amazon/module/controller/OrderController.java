package com.amazon.module.controller;

import com.amazon.base.dto.BaseRequestDto;
import com.amazon.base.dto.BaseResponseDto;
import com.amazon.base.util.GenerateUtil;
import com.amazon.module.constant.CommonValue;
import com.amazon.module.dto.ParamsDto;
import com.amazon.module.entity.Address;
import com.amazon.module.entity.Order;
import com.amazon.module.entity.PlaceName;
import com.amazon.module.entity.User;
import com.amazon.module.service.OrderService;
import com.amazon.module.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

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
     * @function 下订单
     * @param baseReq 下订单所需的信息
     * @return 返回下订单的结果 1 下订单成功 0 下订单失败
     * @datetime 2018.7.23 20:17
     * */
    @ApiOperation(value = "下订单")
    @RequestMapping(value = "/placeOrder",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponseDto<String> placeOrder(@RequestBody BaseRequestDto<Order> baseReq){
        BaseResponseDto<String> baseResp=new BaseResponseDto<>();
        baseResp.setTime(baseReq.getTime());
        try{
            Order order=baseReq.getData();
            order.setOid(GenerateUtil.generateOrderId());
            order.setUser(new User());
            String oid=os.placeOrder(order);
            baseResp.setData(oid);
            baseResp.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            baseResp.setSuccess(false);
        }
        return baseResp;
    }

    /**
     * @function 获取地名集合
     * @param baseReq 所需的父类id
     * @return 地名集合
     * @datetime 2018.8.9 19:55
     * */
    @ApiOperation(value = "下订单")
    @RequestMapping(value = "/getPlaceNameListByParentId",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponseDto<List<PlaceName>> getPlaceNameListByParentId(@RequestBody BaseRequestDto<ParamsDto> baseReq){
        BaseResponseDto<List<PlaceName>> baseResp=new BaseResponseDto<>();
        baseResp.setTime(baseReq.getTime());
        try{
            ParamsDto params=baseReq.getData();
            List<PlaceName> places=os.getPlaceNameListByParentId(params);
            baseResp.setData(places);
            baseResp.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            baseResp.setSuccess(false);
        }
        return baseResp;
    }

    /**
     * @function 存储新的地址
     * @param baseReq 新地址信息
     * @return 操作结果
     * @datetime 2018.8.12 16:38
     * */
    @ApiOperation(value = "存储新地址")
    @RequestMapping(value = "/saveNewAddress",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponseDto<String> saveNewAddress(@RequestBody BaseRequestDto<Address> baseReq,@SessionAttribute(CommonValue.USER)User user){
        BaseResponseDto<String> baseResp=new BaseResponseDto<>();
        baseResp.setTime(baseReq.getTime());
        try{
            Address address=baseReq.getData();
            address.setUserId(user.getUser_id());
            int i=os.saveNewAddress(address);
            baseResp.setData(CommonValue.DESIRED);
            baseResp.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            baseResp.setSuccess(false);
        }
        return baseResp;
    }

    /**
     * @function 获取我的所有地址
     * @param user session中的用户信息
     * @return 当前用户的所有地址
     * @datetime 2018.8.12 17:54
     * */
    @ApiOperation(value = "获取用户的地址")
    @RequestMapping(value = "/getMyAddress",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponseDto<List<Address>> getMyAddress(@SessionAttribute(CommonValue.USER)User user){
        BaseResponseDto<List<Address>> baseResp=new BaseResponseDto<>();
        baseResp.setTime(System.currentTimeMillis());
        try{
            List<Address> addresses=os.getMyAddress(user.getUser_id());
            baseResp.setData(addresses);
            baseResp.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            baseResp.setSuccess(false);
        }
        return baseResp;
    }

    /**
     * @function 改变用户的默认地址
     * @param user session中的用户信息
     * @param baseReq 要设置成默认地址的地址id
     * @return 更新结果
     * @datetime 2018.8.12 19:21
     * */
    @ApiOperation(value = "改变默认收货地址")
    @RequestMapping(value = "/changeMyDefaultAddress",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponseDto<String> changeMyDefaultAddress(@RequestBody BaseRequestDto<ParamsDto> baseReq,@SessionAttribute(CommonValue.USER)User user){
        BaseResponseDto<String> baseResp=new BaseResponseDto<>();
        baseResp.setTime(System.currentTimeMillis());
        try{
            ParamsDto params=baseReq.getData();
            params.setUserId(user.getUser_id());
            boolean result=os.changeMyDefaultAddress(params);
            if(result){
                baseResp.setData(CommonValue.DESIRED);
            }else {
                baseResp.setData(CommonValue.UNDESIRED);

            }
            baseResp.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            baseResp.setSuccess(false);
        }
        return baseResp;
    }

    /**
     * @function 删除用户的地址
     * @param user session中的用户信息
     * @param baseReq 要删除的地址id
     * @return 更新结果
     * @datetime 2018.9.4 18:39
     * */
    @ApiOperation(value = "删除收货地址")
    @RequestMapping(value = "/deleteMyAddress",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponseDto<String> deleteMyAddress(@RequestBody BaseRequestDto<ParamsDto> baseReq,@SessionAttribute(CommonValue.USER)User user){
        BaseResponseDto<String> baseResp=new BaseResponseDto<>();
        baseResp.setTime(System.currentTimeMillis());
        try{
            ParamsDto params=baseReq.getData();
            params.setUserId(user.getUser_id());
            boolean result=os.deleteMyAddress(params);
            if(result){
                baseResp.setData(CommonValue.DESIRED);
            }else {
                baseResp.setData(CommonValue.UNDESIRED);

            }
            baseResp.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            baseResp.setSuccess(false);
        }
        return baseResp;
    }
}
