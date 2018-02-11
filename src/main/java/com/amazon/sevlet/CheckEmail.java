package com.amazon.sevlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazon.entity.HWUA_USER;
import com.amazon.service.IUserService;
import com.amazon.service.impl.UserServiceImpl;

public class CheckEmail extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		IUserService us = new UserServiceImpl();
		HWUA_USER user = us.CheckEmail(email);
		int row = 0;
		if(user!=null){
			row=1;
		}
		resp.getWriter().write(row);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
