package com.revature.app;

import com.revature.user.User;

public class BankApp {

	public static void main(String[] args) {
		User user1 = new User("Luke", "Skywalker", "skywalker.skywalkerranch.com");
		
		System.out.println(user1);
		
		user1.setAdmin(true);
		
		System.out.println(user1);
		user1.setApprovedUser(true);
		
		user1.deposit(10.00);
		user1.withdraw(5.00);
		
		System.out.println(user1.getAccount());
	}

}
