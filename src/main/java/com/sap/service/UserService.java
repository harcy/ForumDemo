package com.sap.service;

import com.sap.entity.User;
import com.sap.map.UserMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    private final Logger logger = Logger.getLogger(UserService.class);

    public User selectUserById(Integer userId) {
        User user = userMapper.getUserById(userId);
        logger.debug("******begin******");
        logger.debug(user.toString());
        logger.debug("******end******");
        return user;

    }
}
