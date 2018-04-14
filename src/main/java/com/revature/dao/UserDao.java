package com.revature.dao;

import java.util.List;

import com.revature.user.User;

public interface UserDao {
	
	boolean insertUser(User user);
	User getUser(String email);
	List<User> getUsers();
	boolean updateUser();
	boolean deleteUser();
	boolean approveUser(String userEmail, String adminEmail) throws Exception;
	boolean deposit(String email, double amountToDeposit) throws Exception;
	boolean withdraw(String email, double amountToWithdraw) throws Exception;
	
}
