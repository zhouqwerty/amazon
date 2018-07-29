package com.amazon.module.filter;

import com.alibaba.fastjson.JSON;
import com.amazon.base.dto.BaseResponseDto;
import com.amazon.base.util.CommonUtil;
import com.amazon.module.dto.ParamsDto;
import com.amazon.module.entity.User;
import com.amazon.module.service.UserService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 岸久
 * @version 1.0
 * @datetime 2018.7.26 20:07
 * @describe 该过滤器用于身份验证
 * */
@Component("authFilter")
public class AuthFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        boolean flag=false;
        HttpServletRequest req=(HttpServletRequest)servletRequest;
        HttpServletResponse resp=(HttpServletResponse)servletResponse;
        HttpSession session=req.getSession();
        String token=null;
        Cookie[] cookies=req.getCookies();
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
                flag=true;
            }
        }
        if(flag){
            chain.doFilter(req,resp);
        }else{
            BaseResponseDto<String> baseResp=new BaseResponseDto<>();
            baseResp.setTime(System.currentTimeMillis());
            baseResp.setData("unLogin");
            baseResp.setSuccess(true);
            resp.setContentType("application/json; charset=utf-8");
            resp.getWriter().append(JSON.toJSONString(baseResp));
        }

    }

    @Override
    public void destroy() {

    }
}
