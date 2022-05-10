package ru.itis.ruzavin.infsecondsemsemesterwork.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.UserDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.models.User;
import ru.itis.ruzavin.infsecondsemsemesterwork.security.VkAuth;
import ru.itis.ruzavin.infsecondsemsemesterwork.security.details.CustomUserDetails;
import ru.itis.ruzavin.infsecondsemsemesterwork.services.UserService;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/signIn")
public class SignInController {

	private final UserService userService;

	@GetMapping
	public String getSignInPage(Authentication authentication, @RequestParam(value = "reason", required = false) String reason) {
		if (authentication != null) {
			return "redirect:/profile";
		}

		if (reason != null && reason.equals("error")) {
			return "signInFailed";
		}

		return "signIn";
	}

	@GetMapping("/vk")
	public String loginWithVk(HttpSession session, @RequestParam("first_name") String firstName,
	                          @RequestParam("last_name") String lastName,
	                          @RequestParam("uid") String id,
	                          @RequestParam("photo") String avatarUrl) {

		User user = User.builder()
				.nick(firstName + " " + lastName)
				.role(User.Role.USER)
				.state(User.State.CONFIRMED)
				.avatarUrl(avatarUrl)
				.confirmCode(id)
				.buildComments(Collections.emptySet())
				.guideComments(Collections.emptySet())
				.builds(Collections.emptySet())
				.guides(Collections.emptySet())
				.email("don't know")
				.build();

		Authentication auth = new VkAuth(new CustomUserDetails(user));
		SecurityContextHolder.getContext().setAuthentication(auth);

		Optional<UserDto> userDto = userService.saveUser(user);
		session.setAttribute("user", userDto.get());

		return "redirect:/profile";
	}

}
