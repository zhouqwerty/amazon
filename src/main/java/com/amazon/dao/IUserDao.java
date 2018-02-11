package com.amazon.dao;

import java.sql.Timestamp;
import java.util.Date;

import com.amazon.entity.HWUA_USER;

public interface IUserDao {
	/**
	 * 通过用户名和密码查询用户
	 * @param name 用户名
	 * @param paw 密码
	 * @return 成功返回一个user，失败返回null
	 */
	public HWUA_USER QueryByNamePaw(String name,String paw);
	/**
	 * 添加一个用户
	 * @param user 用户对象
	 * @return 成功返回1 ，失败返回0
	 */
	public int addUser(HWUA_USER user);
	
	/**
	 * 通过用户名查询用户信息
	 * @param name 用户名
	 * @return 成功返回user 失败返回null
	 */
	public HWUA_USER QueryByName(String name);
	
	/**
	 * 通过email 查询用户信息
	 * @param email 电子邮箱
	 * @return 成功返回user 失败返回null
	 */
	public HWUA_USER QueryByEmail(String email);
	
	
}
