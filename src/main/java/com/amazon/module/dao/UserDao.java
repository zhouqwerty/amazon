package com.amazon.module.dao;

import com.amazon.module.entity.User;

/**
 * @author 岸久
 * @version 1.0
 * @datetime 2018.7.23 20:21
 * @describe 该dao处理用户表的操作
 * */
public interface UserDao {
    int addUser(User u);

    User queryUser(User user);

}
