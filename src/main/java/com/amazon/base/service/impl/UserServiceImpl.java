package com.amazon.base.service.impl;

import com.amazon.base.dao.UserDao;
import com.amazon.base.entity.User;
import com.amazon.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao ud;

    public int registerUser(User u) {
        ud.addUser(u);
        return 1;
    }
}
