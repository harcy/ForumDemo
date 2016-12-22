package com.sap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sap.dao.UserDao;
import com.sap.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	public User getUserById(String userId){
		return userDao.selectUserById(userId);
	}

}
