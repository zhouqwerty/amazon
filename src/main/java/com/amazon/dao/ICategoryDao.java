package com.amazon.dao;

import java.util.List;

import com.amazon.entity.product_category;

public interface ICategoryDao {
	/**
	 * 查询大类型商品类别信息
	 * @return 商品类别集合
	 */
	public List<product_category> QueryBig();
	
	/**
	 * 查询小类型商品类别信息
	 * @return 商品类别集合
	 */
	public List<product_category> QueryLittle(long id);
}
