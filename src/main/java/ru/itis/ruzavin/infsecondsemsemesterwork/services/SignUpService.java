package ru.itis.ruzavin.infsecondsemsemesterwork.services;

import ru.itis.ruzavin.infsecondsemsemesterwork.dto.SignUpForm;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.UserDto;

public interface SignUpService {
	UserDto signUp(SignUpForm form);
}
