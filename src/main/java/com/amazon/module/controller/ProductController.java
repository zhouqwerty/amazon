package com.amazon.module.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.amazon.base.dto.BaseRequestDto;
import com.amazon.base.dto.BaseResponseDto;
import com.amazon.base.util.CommonUtil;
import com.amazon.base.util.GenerateUtil;
import com.amazon.module.dto.ParamsDto;
import com.amazon.module.entity.Order;
import com.amazon.module.entity.Product;
import com.amazon.module.entity.User;
import com.amazon.module.service.OrderService;
import com.amazon.module.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author 岸久
 * @version 1.0
 * @datetime 2018.7.30 18:51
 * @describe 该接口用于处理关于商品信息的请求
 * */
@Api(description = "商品接口")
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService ps;

    /**
     * @function 获取商品分类的目录树
     * @return 商品分类目录树
     * @datetime 2018.7.30 18:56
     * */
    @ApiOperation(value = "商品分类目录树")
    @RequestMapping(value = "/getProductCategory",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponseDto<Object> getProductCategory(){
        BaseResponseDto<Object> baseResp=new BaseResponseDto<>();
        baseResp.setTime(System.currentTimeMillis());
        try{
            JSONArray category=ps.getProductCategory();
            baseResp.setData(category);
            baseResp.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            baseResp.setSuccess(false);
        }
        return baseResp;
    }


    /**
     * @function 搜索商品（模糊查询或者分类）
     * @param baseReq 搜索商品所需参数
     * @return 搜索商品（分页）
     * @datetime 2018.8.1 18:53
     * */
    @ApiOperation(value = "搜索商品")
    @RequestMapping(value = "/getProductsByPage",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponseDto<Map<String,Object>> getProductsByPage(@RequestBody BaseRequestDto<ParamsDto> baseReq){
        BaseResponseDto<Map<String,Object>> baseResp=new BaseResponseDto<>();
        baseResp.setTime(System.currentTimeMillis());
        try{
            Map<String,Object> products=null;
            ParamsDto params=baseReq.getData();
            if(!CommonUtil.isNullOrEmpty(params.getPpDto().getSearch())){
                products=ps.getProductPageBySearch(params);
            }else if(!CommonUtil.isNullOrEmpty(params.getPpDto().getPcid())){
                products=ps.getProductPageByCategory(params);
            }
            baseResp.setData(products);
            baseResp.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            baseResp.setSuccess(false);
        }
        return baseResp;
    }
}
