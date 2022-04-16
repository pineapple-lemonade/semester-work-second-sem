package ru.itis.ruzavin.infsecondsemsemesterwork.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/builds")
public class BuildController {

	@GetMapping
	public String getBuildsPage() {
		return "allBuilds";
	}
}
