package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.user.User;
import com.revature.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {

	public static void main(String[] args) {
		UserDaoImpl dao = new UserDaoImpl();
		List<User> users = dao.getUsers();
		System.out.println(users);
	}
	
	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUser(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsers() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			List<User> users = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT first_name, last_name, email, user_password, account_balance FROM bank_user");
			ResultSet rs = stmt.executeQuery();
			System.out.println();
			while (rs.next()) {
				users.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			return users;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getSQLState());
			System.err.println(e.getErrorCode());
		}
		return null;
	}

	@Override
	public boolean updateUser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser() {
		// TODO Auto-generated method stub
		return false;
	}

}
