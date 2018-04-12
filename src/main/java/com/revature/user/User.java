package com.revature.user;

import java.io.Serializable;

import org.apache.log4j.Logger;

public class User implements Serializable {
	private static final long serialVersionUID = -4322741401222586340L;

	private final Logger log = Logger.getLogger(User.class);
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private double account;
	private boolean isAdmin;
	private boolean isApprovedUser;
	
	public User() {}
	
	public User(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.account = 0.00;
		this.isAdmin = false;
		this.isApprovedUser = false;
	}
	
	public void approveUser(User user) {
		if (user.isAdmin) {
			System.out.println("Would you like to approve this User");
//			String answer = scan.nextString();
			String answer = "yes";
			if (answer.toLowerCase() == "yes") {
				user.isApprovedUser = true;
			} else {
				System.out.println("User is not approved");
			}
		} else {
			System.out.println("Must have Admin permissions");
		}
	}
	
	public void withdraw(double amountToWithdraw) {
		if (this.isApprovedUser) {
			account -= amountToWithdraw;
			log.info("Withdrew " + amountToWithdraw);
		}
	}
			
	public void deposit(double amountToDeposit) {
		if (this.isApprovedUser) {
			account += amountToDeposit;
			log.info("Deposited " + amountToDeposit);
		}
	}
			
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getAccount() {
		return account;
	}

	public void setAccount(double account) {
		this.account = account;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean isApprovedUser() {
		return isApprovedUser;
	}

	public void setApprovedUser(boolean isApprovedUser) {
		this.isApprovedUser = isApprovedUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(account);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (isAdmin ? 1231 : 1237);
		result = prime * result + (isApprovedUser ? 1231 : 1237);
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (Double.doubleToLongBits(account) != Double.doubleToLongBits(other.account))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (isAdmin != other.isAdmin)
			return false;
		if (isApprovedUser != other.isApprovedUser)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password
				+ ", account=" + account + ", isAdmin=" + isAdmin + ", isApprovedUser=" + isApprovedUser + "]";
	}
	
	
}
