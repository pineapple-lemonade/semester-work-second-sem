package ru.itis.ruzavin.infsecondsemsemesterwork.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.UserDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.models.User;
import ru.itis.ruzavin.infsecondsemsemesterwork.repositories.UserRepository;
import ru.itis.ruzavin.infsecondsemsemesterwork.services.UserService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Override
	public Optional<UserDto> findUserByEmail(String email) {
		Optional<User> user = userRepository.findByEmail(email);

		if (user.isEmpty()) {
			return Optional.empty();
		} else {
			return Optional.of(UserDto.from(user.get()));
		}
	}

	@Override
	public Optional<UserDto> findUserByNick(String nick) {
		Optional<User> user = userRepository.findByNick(nick);

		if (user.isEmpty()) {
			return Optional.empty();
		} else {
			return Optional.of(UserDto.from(user.get()));
		}
	}
}
