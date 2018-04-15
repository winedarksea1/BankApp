package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.exceptions.UserDoesNotExistException;
import com.revature.user.User;
import com.revature.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {

	private static UserDaoImpl instance;
	
	private UserDaoImpl() {}
	
	public static UserDaoImpl getInstance() {
		if (instance == null) {
			instance = new UserDaoImpl();
		}
		return instance;
	}
	
	@Override
	public boolean insertUser(User user) {

		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO bank_user VALUES (null, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getPassword());
			stmt.setDouble(5, user.getAccountBalance());
			stmt.setInt(6, 0);
			stmt.setInt(7, 0);
			
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getSQLState());
			System.err.println(e.getErrorCode());
		}
		
		return false;
	}

	@Override
	public User getUser(String email) throws UserDoesNotExistException {
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT first_name, last_name, email, user_password, account_balance, is_admin, is_approved_user FROM bank_user WHERE email=?");
			stmt.setString(1, email);
			
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				boolean isAdmin = rs.getInt(6) == 1;
				boolean isApprovedUser = rs.getInt(7) == 1;
				return new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), isAdmin, isApprovedUser);
			} else {
				throw new UserDoesNotExistException("User Not Found");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getSQLState());
			System.err.println(e.getErrorCode());
		}
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
	
	@Override
	public boolean approveUser(String userEmail, String adminEmail) throws Exception {
		User user = getUser(userEmail);
		User admin = getUser(adminEmail);
		
		if (!admin.isAdmin()) {
			throw new Exception("Must Have Admin Privelages to Approve User");
		} else {
			try (Connection conn = ConnectionUtil.getConnection()) {
				PreparedStatement stmt = conn.prepareStatement("UPDATE bank_user SET is_approved_user=? WHERE email=?");
				stmt.setInt(1, 1);
				stmt.setString(2, userEmail);
				
				return stmt.executeUpdate() > 0;
			} catch (SQLException e) {
				System.err.println(e.getMessage());
				System.err.println(e.getSQLState());
				System.err.println(e.getErrorCode());
			}
		}
		
		return false;
	}

	@Override
	public boolean deposit(String email, double amountToDeposit) throws Exception {
		User user = getUser(email);
//		user.setApprovedUser(true);
		if (!user.isApprovedUser()) {
			throw new Exception("Must be approved to make deposit");
		}
		
		user.deposit(amountToDeposit);
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("UPDATE bank_user SET account_balance=? WHERE email=?");
			stmt.setDouble(1, user.getAccountBalance());
			stmt.setString(2, email);
			
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getSQLState());
			System.err.println(e.getErrorCode());
		}
		return false;
	}

	@Override
	public boolean withdraw(String email, double amountToWithdraw) throws Exception {
		User user = getUser(email);
//		user.setApprovedUser(true);
		if (!user.isApprovedUser()) {
			throw new Exception("Must be approved User to make Withdrawal");
		}
		
		user.withdraw(amountToWithdraw);
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("UPDATE bank_user SET account_balance=? WHERE email=?");
			stmt.setDouble(1, user.getAccountBalance());
			stmt.setString(2, user.getEmail());
			
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getSQLState());
			System.err.println(e.getErrorCode());
		}
		return false;
	}



}
