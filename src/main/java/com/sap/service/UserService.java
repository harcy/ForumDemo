package com.sap.service;

import com.sap.map.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sap.dao.UserDao;
import com.sap.entity.User;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User selectUserById(Integer userId) {
        User user = userMapper.getUserById(userId);
        return user;
    }
    /*@Autowired
	private UserDao userDao;
	public User getUserById(String userId){
		return userDao.selectUserById(userId);
	}*/
}
