package ru.itis.ruzavin.infsecondsemsemesterwork.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.SignUpForm;
import ru.itis.ruzavin.infsecondsemsemesterwork.services.SignUpService;

import javax.servlet.http.HttpServletRequest;

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
	public String signUp(SignUpForm form, HttpServletRequest request) {
		signUpService.signUp(form, request);
		return "redirect:/profile";
	}


}
