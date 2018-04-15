package com.revature.exceptions;

public class UserDoesNotExistException extends Exception {
	private String message;
	
	public UserDoesNotExistException() {}
	
	public UserDoesNotExistException(String message) {
		this.message = message;
	}
	public String getMessage() {
		return "User Does Not Exist in Database";
	}
}
