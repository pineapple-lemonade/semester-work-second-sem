package ru.itis.ruzavin.infsecondsemsemesterwork.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.UserDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/handleUsers")
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
}
