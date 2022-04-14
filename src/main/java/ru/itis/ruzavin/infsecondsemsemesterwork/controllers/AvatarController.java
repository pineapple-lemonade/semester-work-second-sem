package ru.itis.ruzavin.infsecondsemsemesterwork.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.UserDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.services.UserService;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class AvatarController {

	private final UserService userService;

	@PostMapping("/upload")
	public String updateAvatar(HttpSession session, @RequestParam("avatar") MultipartFile avatar) {
		UserDto user = (UserDto) session.getAttribute("user");
		UserDto userDto = userService.updateAvatar(avatar, user).get();
		session.setAttribute("user", userDto);
		return "redirect:/profile";
	}
}
