package ru.itis.ruzavin.infsecondsemsemesterwork.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.SignUpForm;
import ru.itis.ruzavin.infsecondsemsemesterwork.models.User;
import ru.itis.ruzavin.infsecondsemsemesterwork.services.SignUpService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/signUp")
public class SignUpController {

	private final SignUpService signUpService;

	@GetMapping
	public String getSignUpPage(Authentication authentication, Model model) {
		if (authentication != null) {
			return "redirect:/profile";
		}

		model.addAttribute("signUpForm", new SignUpForm());
		return "signUp";
	}

	@PostMapping
	public String signUp(SignUpForm form) {
		signUpService.signUp(form);
		return "redirect:/profile";
	}

	@GetMapping("/confirm/{confirmCode}")
	public String confirmUser(@PathVariable String confirmCode) {
		signUpService.confirmUserByCode(confirmCode);
		return "redirect:/signIn";
	}

}
