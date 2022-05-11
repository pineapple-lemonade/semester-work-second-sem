package ru.itis.ruzavin.infsecondsemsemesterwork.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.UserDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.models.User;
import ru.itis.ruzavin.infsecondsemsemesterwork.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserHandlerController {
	private final UserService userService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<UserDto> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{nickname}")
	@ResponseStatus(HttpStatus.OK)
	public List<UserDto> getUsersNickContains(@PathVariable("nickname") String nick) {
		return userService.getUsersByNick(nick);
	}

	@PostMapping
	public UserDto saveUser(User user) {
		return userService.saveUser(user).orElse(new UserDto());
	}

	@PutMapping
	public UserDto updateUser(UserDto user) {
		return userService.updateUser(user).orElse(new UserDto());
	}

	@DeleteMapping
	public void deleteUser(Integer id) {
		userService.deleteUserById(id);
	}
}
