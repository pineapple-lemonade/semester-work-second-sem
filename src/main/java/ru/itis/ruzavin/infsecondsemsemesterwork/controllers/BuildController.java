package ru.itis.ruzavin.infsecondsemsemesterwork.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.AddBuildDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.UserDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.services.BuildService;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/builds")
public class BuildController {

	private final BuildService buildService;

	@GetMapping
	public String getBuildsPage() {
		return "allBuilds";
	}

	@PostMapping("/add")
	public String addGuide(@RequestParam("photo") MultipartFile pic, AddBuildDto addBuildDto, HttpSession session){
		UserDto user = (UserDto) session.getAttribute("user");
		buildService.createBuild(pic, addBuildDto, user.getId());
		return "redirect:/builds/add";
	}

	@GetMapping("/add")
	public String getAddGuidePage() {
		return "addBuild";
	}

	@GetMapping("/{id}")
	public String getBuildPage(@PathVariable("id") Integer buildId, Model model) {
		model.addAttribute("build", buildService.getBuildById(buildId).get());
		model.addAttribute("author", buildService.findUserByBuildId(buildId).get());
		return "buildInfo";
	}
}
