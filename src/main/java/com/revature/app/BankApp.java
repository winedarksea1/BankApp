package com.revature.app;

import java.sql.Connection;
import java.util.List;

import com.revature.service.UserService;
import com.revature.user.User;
import com.revature.util.ConnectionUtil;

public class BankApp {

	public static void main(String[] args) {
		User user1 = new User("Luke", "Skywalker", "skywalker.skywalkerranch.com", "skywalker");
		Connection conn = ConnectionUtil.getConnection();
		
		System.out.println(user1);
		
		user1.setAdmin(true);
		
		System.out.println(user1);
		user1.setApprovedUser(true);
		
		user1.deposit(10.00);
		user1.withdraw(5.00);
		
		System.out.println(user1.getAccountBalance());
		
		System.out.println(conn);
		
		UserService us = new UserService();

		List<User> users = us.getUsers();
		System.out.println("Users: " + users);
	}

}
