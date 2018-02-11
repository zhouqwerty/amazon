package com.amazon.dao.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.amazon.dao.IUserDao;
import com.amazon.entity.HWUA_USER;
import com.amazon.utils.JDBCUtils;

public class UserDaoImpl implements IUserDao{

	@Override
	public HWUA_USER QueryByNamePaw(String name, String paw) {
		QueryRunner run = JDBCUtils.getQueryRunner();
		HWUA_USER user = null;
		String sql = "select * from HWUA_USER where HU_USER_NAME=? and HU_PASSWORD=?";
		 try {
			user = run.query(sql, new BeanHandler<>(HWUA_USER.class), name,paw);
			System.out.println(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int addUser(HWUA_USER user) {
		QueryRunner run = JDBCUtils.getQueryRunner();
		int row = 0;
		String sql="insert into HWUA_USER (HU_USER_ID, HU_USER_NAME, HU_PASSWORD, HU_SEX, HU_BIRTHDAY,HU_IDENTITY_CODE, HU_EMAIL, HU_MOBILE, HU_ADDRESS, HU_STATUS)"
				+ "values (SEQ_USER.NEXTVAL, ?,?,?,?,?,?,?,?,?)";
		
		try {
			run.update(sql, user.getHU_USER_NAME(),user.getHU_PASSWORD(),user.getHU_SEX()
						,user.getHU_BIRTHDAY(),user.getHU_IDENTITY_CODE(),user.getHU_EMAIL(),user.getHU_MOBILE(),user.getHU_ADDRESS(),1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public HWUA_USER QueryByName(String name) {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "select * from HWUA_USER where HU_USER_NAME=?";
		HWUA_USER user = null;
		try {
			user = run.query(sql, new BeanHandler<>(HWUA_USER.class), name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public HWUA_USER QueryByEmail(String email) {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "select * from HWUA_USER where HU_EMAIL=?";
		HWUA_USER user = null;
		try {
			user = run.query(sql, new BeanHandler<>(HWUA_USER.class), email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
