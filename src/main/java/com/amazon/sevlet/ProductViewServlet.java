package com.amazon.sevlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazon.entity.Pager;
import com.amazon.entity.Product;
import com.amazon.service.IUserService;
import com.amazon.service.impl.UserServiceImpl;

public class ProductViewServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IUserService ius=new UserServiceImpl();
		int currentPage=Integer.parseInt(req.getParameter("page"));
		String hpc_id=req.getParameter("hpcId");
		String Qname=req.getParameter("src");
		Pager pager=new Pager(currentPage);
		List<Product> list=null;
		if(hpc_id!=null&&hpc_id.equals("")){
			pager.setHpc_id(Integer.parseInt(hpc_id));
			list=ius.queryProducts(pager,0);
		}else if(Qname!=null&&Qname.equals("")){
			pager.setQname(Qname);
			list=ius.queryProducts(pager,1);
		}else{
			list=ius.queryProducts(pager,2);
		}
		
		req.setAttribute("list", list);
		req.setAttribute("pager", pager);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
	
}
