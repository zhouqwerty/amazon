package com.amazon.dao;

import java.util.List;

import com.amazon.entity.Pager;
import com.amazon.entity.Product;

public interface IProductDao {
	/**
	 * 查询所有商品信息
	 * @return 成功返回商品集合，失败返回null
	 */
	public List<Product> QueryAllProduct();

	public List<Product> serachAllGoods(int start, int end);

	public List<Product> queryAllProductByQname(int start, int end, String string);

	public List<Product> queryProductsByCategory(int start, int end, int i);

	public List<Product> queryProductByQname(String string);

	public List<Product> queryProductByCategoryId(int i);
}
