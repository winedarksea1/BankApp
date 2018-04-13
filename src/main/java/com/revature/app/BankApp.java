package com.revature.app;

import java.sql.Connection;
import java.util.List;

import com.revature.service.UserService;
import com.revature.user.User;
import com.revature.util.ConnectionUtil;

public class BankApp {

	public static void main(String[] args) {
		Connection conn = ConnectionUtil.getConnection();

		System.out.println(conn);
		
		UserService us = new UserService();

//		List<User> users = us.getUsers();
//		System.out.println("Users: " + users);
//		
		User user = us.getUser("winedark.mcgovern@gmail.com");
		user.setApprovedUser(true);
		System.out.println("Account Balance: " + user.getAccountBalance());
		
//		System.out.println("Was deposit successful: " + us.deposit(user.getEmail(), 5.50));
		
	}

}
