package ru.itis.ruzavin.infsecondsemsemesterwork.services;

import ru.itis.ruzavin.infsecondsemsemesterwork.dto.SignUpForm;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.UserDto;

import javax.servlet.http.HttpServletRequest;

public interface SignUpService {
	//TODO throw exception and handle it
	UserDto signUp(SignUpForm form, HttpServletRequest request);
}
