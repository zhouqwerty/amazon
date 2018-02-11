package com.amazon.service.impl;

import java.util.List;

import com.amazon.dao.IProductDao;
import com.amazon.dao.impl.ProductDaoImpl;
import com.amazon.entity.Product;
import com.amazon.service.IProductService;

public class ProductServiceImpl implements IProductService {
	IProductDao ip = new ProductDaoImpl();
	
	@Override
	public List<Product> ShowProduct() {
		
		return null;
	}

}
