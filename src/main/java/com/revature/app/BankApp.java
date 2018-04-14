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
		System.out.println("Does User have admin privelages: " + user.isAdmin());
//		System.out.println("Is User approved: " + user.isAdmin());

//		user.setApprovedUser(true);
		
//		System.out.println("Account Balance: " + user.getAccountBalance());
		
//		System.out.println("Was deposit successful: " + us.deposit(user.getEmail(), 5.50));
		
//		System.out.println("Was withdrawal successful: " + us.withdraw(user.getEmail(), 3.75));
		
//		User newUser = new User("Lando", "Calrissian", "lando@skycity.net", "skycity");
//		User lando = us.getUser("lando@skycity.net");
//		System.out.println("Was lando approval successful" + us.approveUser(lando.getEmail(), user.getEmail()));
//		System.out.println("User was successfully approved " + us.approveUser(newUser.getEmail(), user.getEmail()));
//		System.out.println("Was deposit successful: " + us.deposit(lando.getEmail(), 10.00));
//		System.out.println("Was withdrawal successful: " + us.withdraw(lando.getEmail(), 2.75));
		User han = us.getUser("solo@smugglers.net");
//		System.out.println("Was han approval successful: " + us.approveUser(han.getEmail(), user.getEmail()));
//		System.out.println("Was Han's deposit successful: " + us.deposit(han.getEmail(), 25.50));
		System.out.println("Was withdrawal successful: " + us.withdraw(han.getEmail(), 10.00));
	}

}
