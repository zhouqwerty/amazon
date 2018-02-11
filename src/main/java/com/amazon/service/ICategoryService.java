package com.amazon.service;

import java.util.List;

import com.amazon.entity.product_category;

public interface ICategoryService {

	/**
	 * 查询所有商品类别
	 * @return 商品类别的集合
	 */
	public Object[][] QueryAll();
}
