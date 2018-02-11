package com.amazon.sevlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazon.entity.HWUA_USER;
import com.amazon.service.IUserService;
import com.amazon.service.impl.UserServiceImpl;

public class loginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("userName");
		String paw = req.getParameter("passWord");
		String veryCode = req.getParameter("veryCode");
		Object code = req.getSession().getAttribute("validateCode");
		
		IUserService us = new UserServiceImpl();
		HWUA_USER user = us.login(name, paw);
		if(veryCode.equals(code) && user.getHU_USER_NAME().equals(name) && user.getHU_PASSWORD().equals(paw)){
			
			req.getSession().setAttribute("user", user);
			resp.sendRedirect("index.jsp");
			
		}else{
			resp.sendRedirect("login.jsp");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
