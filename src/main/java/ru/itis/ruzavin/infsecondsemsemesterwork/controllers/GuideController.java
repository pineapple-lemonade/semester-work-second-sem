package ru.itis.ruzavin.infsecondsemsemesterwork.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.AddGuideDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.UserDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.services.GuideService;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/guides")
public class GuideController {

	private final GuideService guideService;

	@GetMapping
	public String getGuidesPage() {
		return "allGuides";
	}

	@PostMapping("/add")
	public String addGuide(@RequestParam("photo") MultipartFile pic, AddGuideDto addGuideDto, HttpSession session){
		UserDto user = (UserDto) session.getAttribute("user");
		guideService.createGuide(pic, addGuideDto, user.getId());
		return "redirect:/guides/add";
	}

	@GetMapping("/add")
	public String getAddGuidePage() {
		return "addGuide";
	}

	@GetMapping("/{id}")
	public String getGuidePage(@PathVariable("id") Integer guideId, Model model) {
		model.addAttribute("guide", guideService.getGuideById(guideId).get());
		model.addAttribute("author", guideService.findUserByGuideId(guideId).get());
		return "guideInfo";
	}
}
