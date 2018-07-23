package com.amazon.module.service;

import com.amazon.module.entity.User;

/**
 * @author 岸久
 * @version 1.0
 * @datetime 2018.7.23 20:18
 * @describe 该service提供关于用户的服务
 * */
public interface UserService {
    int registerUser(User u);

    User validUser(User user);
}
