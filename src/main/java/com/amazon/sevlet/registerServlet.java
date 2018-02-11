package com.amazon.sevlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazon.entity.HWUA_USER;
import com.amazon.service.IUserService;
import com.amazon.service.impl.UserServiceImpl;

public class registerServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("userName");
		String paw = req.getParameter("passWord");
		String sex = req.getParameter("sex");
		java.sql.Date birthday = java.sql.Date.valueOf(req.getParameter("birthday"));
		String identity = req.getParameter("identity");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String address = req.getParameter("address");
		HWUA_USER user = new HWUA_USER(name, paw, sex, birthday, identity, email, mobile, address, 1);
		String veryCode = req.getParameter("veryCode");
		Object code = req.getSession().getAttribute("validateCode");
		IUserService us = new UserServiceImpl();
		if(code.equals(veryCode)){
			us.register(user);
			resp.sendRedirect("reg-result.jsp");
		}else{
			resp.sendRedirect("register.jsp");
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
