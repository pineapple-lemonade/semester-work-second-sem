package ru.itis.ruzavin.infsecondsemsemesterwork.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.SignUpForm;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.UserDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.exceptions.UserAlreadyExistsException;
import ru.itis.ruzavin.infsecondsemsemesterwork.models.User;
import ru.itis.ruzavin.infsecondsemsemesterwork.repositories.UserRepository;
import ru.itis.ruzavin.infsecondsemsemesterwork.services.SignUpService;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Service
@Slf4j
public class SignUpServiceImpl implements SignUpService {

	private final static String DEFAULT_AVATAR_URL = "https://res.cloudinary.com/de5binygw/image/upload/v1650284936/img_yrmfxs.png";

	private final UserRepository userRepository;

	private final PasswordEncoder passwordEncoder;

	@Override
	public UserDto signUp(SignUpForm form) {
		if (userRepository.findByEmail(form.getEmail()).isPresent() ||
				userRepository.findByNick(form.getNick()).isPresent()) {
			throw new UserAlreadyExistsException();
		}

		User user = User.builder()
				.email(form.getEmail())
				.nick(form.getNick())
				.avatarUrl(DEFAULT_AVATAR_URL)
				.password(passwordEncoder.encode(form.getPassword()))
				.role(User.Role.USER)
				.state(User.State.NOT_CONFIRMED)
				.build();

		return UserDto.from(userRepository.save(user));
	}
}
