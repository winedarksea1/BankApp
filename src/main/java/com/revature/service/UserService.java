package com.revature.service;

import java.util.List;

import com.revature.dao.UserDaoImpl;
import com.revature.user.User;

public class UserService {
	private UserDaoImpl userDao = UserDaoImpl.getInstance();
	
	public User getUser(String email) {
		return userDao.getUser(email);
	}
	
	public List<User> getUsers() {
		return userDao.getUsers();
	}
	
	public boolean deposit(String email, double amountToDeposit) {
		return userDao.deposit(email, amountToDeposit);
	}
}
