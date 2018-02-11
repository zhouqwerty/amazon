package com.amazon.service.impl;

import java.util.List;

import com.amazon.dao.IProductDao;
import com.amazon.dao.IUserDao;
import com.amazon.dao.impl.ProductDaoImpl;
import com.amazon.dao.impl.UserDaoImpl;
import com.amazon.entity.HWUA_USER;
import com.amazon.entity.Pager;
import com.amazon.entity.Product;
import com.amazon.service.IUserService;

public class UserServiceImpl implements IUserService {
	IUserDao id = new UserDaoImpl();
	IProductDao ipd=new ProductDaoImpl();
	@Override
	public HWUA_USER login(String name, String paw) {
		HWUA_USER user = id.QueryByNamePaw(name, paw);
		if(user==null || name==null || paw==null){
			return null;
		}else{
			return user;
		}
	}
	
	
	@Override
	public HWUA_USER registerByname(String name) {
		HWUA_USER user = id.QueryByName(name);
		if(user==null || name==null){
			return null;
		}else{
			return user;
		}
	}


	@Override
	public int register(HWUA_USER user) {
		
		if(user==null){
			return 0;
		}else{
			return id.addUser(user);	
		}
		
	}


	@Override
	public HWUA_USER CheckEmail(String email) {
		HWUA_USER user = id.QueryByEmail(email);
		if(user==null || email==null){
			return null;
		}else{
			return user;
		}
	}


	@Override
	public List<Product> queryProducts(Pager pager,int i) {
		if(i==2){
			pager.setRecordCount(ipd.QueryAllProduct().size());
			return ipd.serachAllGoods(pager.getStart(),pager.getEnd());
		}else if(i==1){
			pager.setRecordCount(ipd.queryProductByQname(pager.getQname()).size());
			return ipd.queryAllProductByQname(pager.getStart(),pager.getEnd(),pager.getQname());
		}else if(i==0){
			pager.setRecordCount(ipd.queryProductByCategoryId(pager.getHpc_id()).size());
			return ipd.queryProductsByCategory(pager.getStart(),pager.getEnd(),pager.getHpc_id());
		}
		return null;
	}

}
