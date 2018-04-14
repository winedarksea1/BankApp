package com.revature.service;

import java.util.List;
import org.apache.log4j.Logger;

import com.revature.dao.UserDaoImpl;
import com.revature.user.User;

public class UserService {
	private UserDaoImpl userDao = UserDaoImpl.getInstance();
	private final Logger log = Logger.getLogger(UserService.class);
	
	public boolean insertUser(User user) {
		try {
			userDao.insertUser(user);
			log.info("=====>> User was successfully inserted");
			return true;
		} catch (Exception e) {
			log.info("=====>> Exception Caught in UserService: " + e.getMessage());
		}
		return false;
	}
	
	public User getUser(String email) {
		return userDao.getUser(email);
	}
	
	public List<User> getUsers() {
		return userDao.getUsers();
	}
	
	public boolean approveUser(String userEmail, String adminEmail) {
		try {
			userDao.approveUser(userEmail, adminEmail);
			log.info("=====>> User was Approved");
			return true;
		} catch (Exception e) {
			log.info("=====>> Exception Caught in UserService: " + e.getMessage());
		}
		return false;
		
	}
	
	public boolean deposit(String email, double amountToDeposit) {
		try {
			userDao.deposit(email, amountToDeposit);
			log.info("=====> Deposit Successful");
			return true;
		} catch (Exception e) {
			log.info("=====>> Exception Caught in UserService " + e.getMessage());
		}
		return false;
	}
	
	public boolean withdraw(String email, double amountToWithdraw) {
		try {
			userDao.withdraw(email, amountToWithdraw);
			log.info("=====>> Withdrawal Successful");
			return true;
		} catch (Exception e) {
			log.info("=====>> Exception Caught in UserService " + e.getMessage());
		}
		return false;
	}
}
