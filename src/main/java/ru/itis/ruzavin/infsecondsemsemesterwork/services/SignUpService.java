package ru.itis.ruzavin.infsecondsemsemesterwork.services;

import ru.itis.ruzavin.infsecondsemsemesterwork.dto.SignUpForm;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.UserDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.models.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public interface SignUpService {
	UserDto signUp(SignUpForm form);
	Optional<User> confirmUserByCode(String confirmCode);
}
