package com.amazon.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.amazon.dao.IProductDao;
import com.amazon.dao.impl.ProductDaoImpl;
import com.amazon.entity.Pager;
import com.amazon.entity.Product;

public class ProductFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		IProductDao ipd=new ProductDaoImpl();
		String currentPage=req.getParameter("currentPage");
		int p=1;
		if(currentPage!=null){
			p = Integer.parseInt(currentPage);
		}
		Pager pager = new Pager(p);//2.初始化分页对象
		//3.编写service层getAllGoods方法传入pager对象
		// 5.计算起始和结束位置
		int start = (pager.getCurrentPage() - 1) * Pager.PAGE_RECORD;
		int end = start + Pager.PAGE_RECORD;
		//6.编写GoodsDao的serachAllGoods方法传入start和end
		List<Product> list =ipd.serachAllGoods(start, end);
		List<Product> all=ipd.QueryAllProduct();
		pager.setRecordCount(all.size());
		//7.将集合和page对象存入request作用域中
		req.setAttribute("list", list);
		req.setAttribute("pager", pager);
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
