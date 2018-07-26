package com.amazon.module.filter;

import com.amazon.module.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 岸久
 * @version 1.0
 * @datetime 2018.7.26 20:07
 * @describe 该过滤器用于身份验证
 * */
@Component("authFilter")
public class AuthFilter implements Filter{

    @Autowired
    private UserService us;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("AuthFilter");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
