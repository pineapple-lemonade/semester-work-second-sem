package ru.itis.ruzavin.infsecondsemsemesterwork.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.GuideDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.services.GuideService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/handleGuides")
public class GuidesHandlerController {

	private final GuideService guideService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<GuideDto> getAllGuides() {
		return guideService.getAllGuides();
	}

	@GetMapping("/{title}")
	@ResponseStatus(HttpStatus.OK)
	public List<GuideDto> getGuidesByTitle(@PathVariable String title) {
		return guideService.getAllGuidesByTitle(title);
	}
}
