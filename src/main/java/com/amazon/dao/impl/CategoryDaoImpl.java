package com.amazon.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.amazon.dao.ICategoryDao;
import com.amazon.entity.product_category;
import com.amazon.utils.JDBCUtils;

public class CategoryDaoImpl implements ICategoryDao{

	@Override
	public List<product_category> QueryBig() {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "select * from HWUA_PRODUCT_CATEGORY where HPC_ID=HPC_PARENT_ID";
		List<product_category> list =null;
		try {
			 list = run.query(sql, new BeanListHandler<>(product_category.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<product_category> QueryLittle(long id) {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "select * from HWUA_PRODUCT_CATEGORY where HPC_PARENT_ID=? and HPC_ID!=?";
		List<product_category> list =null;
		try {
			 list =  run.query(sql, new BeanListHandler<>(product_category.class), id,id);
			
			 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
	}

}
