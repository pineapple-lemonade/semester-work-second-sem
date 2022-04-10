package ru.itis.ruzavin.infsecondsemsemesterwork.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.SignUpForm;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.UserDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.models.User;
import ru.itis.ruzavin.infsecondsemsemesterwork.repositories.UserRepository;
import ru.itis.ruzavin.infsecondsemsemesterwork.services.SignUpService;

@RequiredArgsConstructor
@Service
public class SignUpServiceImpl implements SignUpService {

	private final UserRepository userRepository;

	private final PasswordEncoder passwordEncoder;

	//TODO throw exception and handle it
	@Override
	public UserDto signUp(SignUpForm form) {
		User user = User.builder()
				.email(form.getEmail())
				.nick(form.getNick())
				.avatarUrl(form.getAvatarUrl())
				.password(passwordEncoder.encode(form.getPassword()))
				.role(User.Role.USER)
				.state(User.State.NOT_CONFIRMED)
				.build();

		return UserDto.from(userRepository.save(user));
	}
}
