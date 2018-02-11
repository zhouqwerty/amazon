package com.amazon.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.amazon.dao.IProductDao;
import com.amazon.entity.Product;
import com.amazon.utils.JDBCUtils;

public class ProductDaoImpl implements IProductDao{

	@Override
	public List<Product> QueryAllProduct() {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "select * from HWUA_PRODUCT";
		List<Product> list = null;
		try {
			list = run.query(sql, new BeanListHandler<>(Product.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Product> serachAllGoods(int start, int end) {
		List<Product> list = null;
		//这边要自己写连接
		//table_goods*2表名需要更改
		String sql = "select t.* from(select rownum as r, HWUA_PRODUCT.* from HWUA_PRODUCT)t where t.r > ? and t.r <=?";
		QueryRunner run=JDBCUtils.getQueryRunner();
		
		try {
			list=run.query(sql, new BeanListHandler<>(Product.class),start,end);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list.size()>0?list:null;
	}

	@Override
	public List<Product> queryAllProductByQname(int start, int end,String Qname){
		List<Product> list =null;
		//这边要自己写连接
		//table_goods*2表名需要更改
		String sql = "select t.* from(select rownum as r, HWUA_PRODUCT.* from HWUA_PRODUCT)t where t.r > ? and t.r <=? and t.hp_name like '%"+Qname+"%'";
		QueryRunner run=JDBCUtils.getQueryRunner();
		
		try {
			list=run.query(sql, new BeanListHandler<>(Product.class),start,end);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list.size()>0?list:null;
	}

	@Override
	public List<Product> queryProductsByCategory(int start, int end,int categoryId) {
		List<Product> list =null;
		//这边要自己写连接
		//table_goods*2表名需要更改
		String sql = "select t.* from(select rownum as r, HWUA_PRODUCT.* from HWUA_PRODUCT)t where t.r > ? and t.r <=? and t.hpc_id=?";
		QueryRunner run=JDBCUtils.getQueryRunner();
		
		try {
			list=run.query(sql, new BeanListHandler<>(Product.class),start,end,categoryId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list.size()>0?list:null;
	}

	@Override
	public List<Product> queryProductByQname(String qname) {
		List<Product> list =null;
		//这边要自己写连接
		//table_goods*2表名需要更改
		String sql = "select * from HWUA_PRODUCT where hp_name like '%"+qname+"%'";
		QueryRunner run=JDBCUtils.getQueryRunner();
		
		try {
			list=run.query(sql, new BeanListHandler<>(Product.class));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list.size()>0?list:null;
	}

	@Override
	public List<Product> queryProductByCategoryId(int categoryId) {
		List<Product> list = null;
		//这边要自己写连接
		//table_goods*2表名需要更改
		String sql = "select  * from HWUA_PRODUCT  where hpc_id=?";
		QueryRunner run=JDBCUtils.getQueryRunner();
		
		try {
			list=run.query(sql, new BeanListHandler<>(Product.class),categoryId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list.size()>0?list:null;
	}

}
