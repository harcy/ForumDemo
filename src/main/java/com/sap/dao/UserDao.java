package com.sap.dao;

import org.springframework.stereotype.Repository;

import com.sap.entity.User;

@Repository
public class UserDao {
	
	public User selectUserById(String userId){
		User user = new User();
		//user.setUserName("admin:"+userId);
		user.setUserName("admin:"+userId);
		user.setUserPwd("123:"+userId);
		return user;
	}

}
