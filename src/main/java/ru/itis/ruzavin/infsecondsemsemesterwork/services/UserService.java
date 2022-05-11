package ru.itis.ruzavin.infsecondsemsemesterwork.services;

import org.springframework.web.multipart.MultipartFile;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.UserDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
	Optional<UserDto> findUserByEmail(String email);

	Optional<UserDto> findUserByNick(String nick);

	Optional<UserDto> updateUser(UserDto user);

	Optional<UserDto> updateAvatar(MultipartFile file, UserDto userDto);

	List<UserDto> getAllUsers();

	List<UserDto> getUsersByNick(String nick);

	Optional<UserDto> saveUser(User user);

	Optional<UserDto> getUserByConfirmCode(String code);

	void deleteUserById(Integer id);

	Optional<UserDto> getUserById(Integer id);
}
