package com.amazon.service.impl;

import java.util.List;

import com.amazon.dao.ICategoryDao;
import com.amazon.dao.impl.CategoryDaoImpl;
import com.amazon.entity.product_category;
import com.amazon.service.ICategoryService;

public class CategoryServiceImpl implements ICategoryService {
	ICategoryDao ip = new CategoryDaoImpl();
	@Override
	public Object[][] QueryAll() {
		List<product_category> list = ip.QueryBig();
		
		Object[][] obj=new Object[list.size()][2];
		for(int i=0; i<list.size();i++){
			System.out.println(i);
			 obj[i][0] = list.get(i);
			 obj[i][1] = ip.QueryLittle(list.get(i).getHPC_ID());
		}
		
		return obj;
	}

}
