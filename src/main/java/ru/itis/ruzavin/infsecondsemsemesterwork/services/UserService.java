package ru.itis.ruzavin.infsecondsemsemesterwork.services;

import ru.itis.ruzavin.infsecondsemsemesterwork.dto.UserDto;

import java.util.Optional;

public interface UserService {
	Optional<UserDto> findUserByEmail(String email);
	Optional<UserDto> findUserByNick(String nick);
}
