package com.amazon.module.service.impl;

import com.amazon.module.dao.UserDao;
import com.amazon.module.entity.User;
import com.amazon.module.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao ud;

    public int registerUser(User u) {
        ud.addUser(u);
        return 1;
    }
}
