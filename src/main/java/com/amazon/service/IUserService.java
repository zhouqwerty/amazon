package com.amazon.service;

import java.util.List;

import com.amazon.entity.HWUA_USER;
import com.amazon.entity.Pager;
import com.amazon.entity.Product;

public interface IUserService {
	
	/**
	 * 通过用户名和密码查询用户信息
	 * @param name 用户名
	 * @param paw 密码
	 * @return 成功返回user 失败返回null
	 */
	public HWUA_USER login(String name,String paw);
	
	/**
	 * 通过用户名 查询用户信息
	 * @param name 用户名
	 * @return 成功返回user  失败返回null
	 */
	public HWUA_USER registerByname(String name);
	
	/**
	 * 注册用户信息
	 * @param user user对象
	 * @return 返回1注册成功 0 注册失败
	 */
	public int register(HWUA_USER user);
	/**
	 * 通过email查询用户信息
	 * @param email 电子邮箱
	 * @return 成功返回user 失败返回null
	 */
	public HWUA_USER CheckEmail(String email);

	public List<Product> queryProducts(Pager pager, int i);
}










