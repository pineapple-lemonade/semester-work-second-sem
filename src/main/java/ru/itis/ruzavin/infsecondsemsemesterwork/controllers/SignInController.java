package ru.itis.ruzavin.infsecondsemsemesterwork.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/signIn")
public class SignInController {

	@GetMapping()
	public String getSignInPage(Authentication authentication, @RequestParam(value = "reason", required = false) String reason) {
		if (authentication != null) {
			return "redirect:/profile";
		}

		if (reason != null && reason.equals("error")) {
			return "signInFailed";
		}

		return "signIn";
	}

}
