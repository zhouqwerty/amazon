package com.amazon.module.dao;

import com.amazon.module.entity.User;

/**
 * @author 岸久
 * @version 1.0
 * @datetime 2018.7.23 20:21
 * @describe 该dao处理用户表的操作
 * */
public interface UserDao {
    /**
     * @function 添加用户
     * @param u 用户信息
     * @return 插入的行数
     * @datetime 2018.8.2 19:14
     * */
    int addUser(User u);

    /**
     * @function 根据用户名密码查询用户
     * @param user 用户名密码
     * @return 根据用户名密码查询的用户信息
     * @datetime 2018.8.2 19:14
     * */
    User queryUser(User user);

}
