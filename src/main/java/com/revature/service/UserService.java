package com.revature.service;

import java.util.List;

import com.revature.dao.UserDaoImpl;
import com.revature.user.User;

public class UserService {
	private UserDaoImpl userDao = new UserDaoImpl();
	
	public List<User> getUsers() {
		return userDao.getUsers();
	}
}
