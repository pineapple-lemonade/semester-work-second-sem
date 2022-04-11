package ru.itis.ruzavin.infsecondsemsemesterwork.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "user already exists")
public class UserAlreadyExistsException extends RuntimeException {
	public UserAlreadyExistsException() {
		super("user already exist");
	}

}
