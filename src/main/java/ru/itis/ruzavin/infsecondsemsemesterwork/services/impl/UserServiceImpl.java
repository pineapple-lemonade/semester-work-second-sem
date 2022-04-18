package ru.itis.ruzavin.infsecondsemsemesterwork.services.impl;

import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.UserDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.exceptions.UserNotExistsException;
import ru.itis.ruzavin.infsecondsemsemesterwork.models.User;
import ru.itis.ruzavin.infsecondsemsemesterwork.repositories.UserRepository;
import ru.itis.ruzavin.infsecondsemsemesterwork.services.UserService;
import ru.itis.ruzavin.infsecondsemsemesterwork.util.CloudinaryHelper;
import ru.itis.ruzavin.infsecondsemsemesterwork.util.ImageHelper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	private final ImageHelper imageHelper;

	private final CloudinaryHelper cloudinaryHelper;

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

	@Override
	public Optional<UserDto> updateUser(UserDto newData) {
		User user = userRepository.findByEmail(newData.getEmail()).orElseThrow(UserNotExistsException::new);
		user.setAvatarUrl(newData.getAvatarUrl());
		user.setNick(newData.getNick());
		user.setState(newData.getState());

		return Optional.of(UserDto.from(userRepository.save(user)));
	}

	@Override
	public Optional<UserDto> updateAvatar(MultipartFile avatar, UserDto user) {
		try {
			File file = imageHelper.makeFile(avatar);
			String filename = "profilePhoto" + user.getId();

			Map upload = CloudinaryHelper.getCloudinary().uploader()
					.upload(file, ObjectUtils.asMap("public_id", filename));
			String url = (String) upload.get("url");
			user.setAvatarUrl(url);
			updateUser(user);
			file.delete();
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		return Optional.of(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		return UserDto.from(userRepository.findAll());
	}

	@Override
	public List<UserDto> getUsersByNick(String nick) {
		return UserDto.from(userRepository.findAllByNickContaining(nick));
	}

	@Override
	public Optional<UserDto> getUserById(Integer id) {
		return Optional.of(UserDto.from(userRepository.getById(id)));
	}
}
