package com.amazon.module.service;

import com.amazon.module.entity.User;

/**
 * @author 岸久
 * @version 1.0
 * @datetime 2018.7.23 20:18
 * @describe 该service提供关于用户的服务
 * */
public interface UserService {
    /**
     * @function 注册用户
     * @param u 用户信息
     * @return 插入的行数
     * @datetime 2018.8.2 19:18
     * */
    int registerUser(User u);

    /**
     * @function 验证用户名密码是否正确
     * @param user 用户名密码
     * @return 用户信息
     * @datetime 2018.8.2 19:18
     * */
    User validUser(User user);
}
