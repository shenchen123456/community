package com.personal.service.impl;

import com.personal.entity.User;
import com.personal.mapper.UserMapper;
import com.personal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: Chen
 * @Data: 2019/9/6
 * @Description: com.personal.service.impl
 * @Version: 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findOneByToken(String token) {
        return userMapper.findOneByToken(token);
    }

    @Override
    public boolean insertUser(User user) {
        return userMapper.insertUser(user);
    }

}
