package ru.itis.ruzavin.infsecondsemsemesterwork.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.BuildDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.services.BuildService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/handleBuilds")
public class BuildsHandlerController {
	private final BuildService buildService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<BuildDto> getAllGuides() {
		return buildService.getAllBuilds();
	}

	@GetMapping("/{title}")
	@ResponseStatus(HttpStatus.OK)
	public List<BuildDto> getGuidesByTitle(@PathVariable String title) {
		return buildService.getAllBuildsByTitle(title);
	}
}
