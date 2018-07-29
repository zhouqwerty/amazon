package com.amazon.module.controller;

import com.amazon.base.dto.BaseRequestDto;
import com.amazon.base.dto.BaseResponseDto;
import com.amazon.base.dto.ValidateCode;
import com.amazon.base.util.CommonUtil;
import com.amazon.base.util.GenerateUtil;
import com.amazon.base.util.SpecialUtil;
import com.amazon.module.dto.ParamsDto;
import com.amazon.module.entity.User;
import com.amazon.module.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.util.Map;

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
     * @return 登录的查询结果
     * @datetime 2018.7.23 20:15
     * */
    @ApiOperation(value = "登录")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponseDto<Object> login(@RequestBody BaseRequestDto<ParamsDto> baseReq, HttpServletResponse resp, HttpSession session){
        BaseResponseDto<Object> baseResp=new BaseResponseDto<>();
        baseResp.setTime(baseReq.getTime());
        try{
            ParamsDto params=baseReq.getData();
            if(validValidateCode(params,session)){
                User result=us.validUser(params.getUser());
                if(!CommonUtil.isNullOrEmpty(result)){
                    String token=GenerateUtil.generateTokeCode();
                    session.setAttribute("token", token);
                    session.setAttribute("user",result);
                    resp.addCookie(new Cookie("token",token));
                }
                baseResp.setData(result);
            }else{
                baseResp.setData("codeError");
            }
            baseResp.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            baseResp.setSuccess(false);
        }
        return baseResp;
    }

    /**
     * @param baseReq 注册所需的信息
     * @return 注册结果 1 注册成功 0 注册失败
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

    /**
     * @return 图片的base64字符串
     * @datetime 2018.7.27 18:57
     * */
    @ApiOperation(value = "获取验证码")
    @RequestMapping(value = "/getValidateCode",method = RequestMethod.POST)
    @ResponseBody
    public  BaseResponseDto<String> getValidateCode(HttpSession session){
        BaseResponseDto<String> baseResp=new BaseResponseDto<>();
        baseResp.setTime(System.currentTimeMillis());
        try{
            Map<String,Object> map=new ValidateCode().getCode();
            String code=(String) map.get("code");
            BufferedImage image=(BufferedImage)map.get("image");
            session.setAttribute("validateCode",code);
            baseResp.setData("data:image/png;base64,"+SpecialUtil.bufferImageToBase64(image));
            baseResp.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            baseResp.setSuccess(false);
        }
        return baseResp;
    }

    /**
     * @return 图片的base64字符串
     * @datetime 2018.7.27 18:57
     * */
    @ApiOperation(value = "验证验证码")
    @RequestMapping(value = "/validValidateCode",method = RequestMethod.POST)
    @ResponseBody
    public  BaseResponseDto<String> validValidateCode(@RequestBody BaseRequestDto<ParamsDto> baseReq,@SessionAttribute("validateCode") String code){
        BaseResponseDto<String> baseResp=new BaseResponseDto<>();
        baseResp.setTime(System.currentTimeMillis());
        try{
            String result="0";
            ParamsDto params=baseReq.getData();
            String validateCode=params.getValidateCode();
            if(validateCode.equalsIgnoreCase(code)){
                result="1";
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
     * @return 是否登录
     * @datetime 2018.7.29 18:54
     * */
    @ApiOperation(value = "是否登录")
    @RequestMapping(value = "/loginCheck",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponseDto<User> loginCheck(HttpServletRequest req, HttpSession session){
        BaseResponseDto<User> baseResp=new BaseResponseDto<>();
        baseResp.setTime(System.currentTimeMillis());
        try{
            Cookie[] cookies=req.getCookies();
            User result=null;
            String token=null;
            String sToken=(String) session.getAttribute("token");
            User user=(User)session.getAttribute("user");
            if(!CommonUtil.isNullOrEmpty(cookies)){
                for(Cookie c:cookies){
                    if(c.getName().equals("token")){
                        token=c.getValue();
                    }
                }
            }
            if(!CommonUtil.isNullOrEmpty(sToken)){
                if(!CommonUtil.isNullOrEmpty(user)&&sToken.equals(token)){
                    result=user;
                }
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
     * @return 是否退出 1 成功注销
     * @datetime 2018.7.29 19:47
     * */
    @ApiOperation(value = "注销")
    @RequestMapping(value = "/cancelLogin",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponseDto<String> cancelLogin(HttpServletRequest req, HttpSession session){
        BaseResponseDto<String> baseResp=new BaseResponseDto<>();
        baseResp.setTime(System.currentTimeMillis());
        try{
            session.removeAttribute("user");
            session.removeAttribute("token");
            baseResp.setData("1");
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


/*--------------------------------------- 非请求方法（private）------------------------------------------------------*/

    /**
     * @param params 前端的验证码
     * @param session 会话
     * @return 验证结果 true 相同 false 不同
     * @datetime 2018.7.29 16:50
     * */
    private boolean validValidateCode(ParamsDto params,HttpSession session){
        boolean result=false;
        String validateCode=params.getValidateCode();
        String code=(String) session.getAttribute("validateCode");
        if(validateCode.equalsIgnoreCase(code)){
            result=true;
        }
        return result;
    }

}
