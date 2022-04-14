package ru.itis.ruzavin.infsecondsemsemesterwork.exceptions;

public class UserNotExistsException extends RuntimeException{
	public UserNotExistsException() {
		super("User is not exists");
	}
}
