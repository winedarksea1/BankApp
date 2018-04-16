package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.exceptions.UserDoesNotExistException;
import com.revature.user.User;

public interface UserDao {
	
	boolean insertUser(User user);
	User getUser(String email) throws UserDoesNotExistException;
	List<User> getUsers();
	boolean deleteUser();
	boolean approveUser(String userEmail, String adminEmail) throws Exception;
	boolean deposit(String email, double amountToDeposit) throws Exception;
	boolean withdraw(String email, double amountToWithdraw) throws Exception;
	double checkBalance(User user) throws UserDoesNotExistException;
	boolean updateUser(String email, String newFirstName, String newLastName)
			throws UserDoesNotExistException, SQLException;

}
