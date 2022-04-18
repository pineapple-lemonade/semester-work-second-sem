package ru.itis.ruzavin.infsecondsemsemesterwork.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.AddCommentDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.CommentDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.UserDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.services.CommentService;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

	private final CommentService commentService;

	@PostMapping("/build/{build-id}")
	public String saveBuildComment(@PathVariable("build-id") Integer buildId,
	                               @RequestParam(value = "text",required = false) String text,
	                               HttpSession session) {
		AddCommentDto newData = AddCommentDto.builder()
				.topicId(buildId)
				.text(text)
				.userId(((UserDto)session.getAttribute("user")).getId())
				.build();

		Optional<CommentDto> buildComment = commentService.createBuildComment(newData);

		return "redirect:/builds/" + buildId;
	}

	@PostMapping("/guide/{guide-id}")
	public String saveGuideComment(@PathVariable("guide-id") Integer guideId,
	                               @RequestParam(value = "text",required = false) String text,
	                               HttpSession session) {
		AddCommentDto newData = AddCommentDto.builder()
				.topicId(guideId)
				.text(text)
				.userId(((UserDto)session.getAttribute("user")).getId())
				.build();

		Optional<CommentDto> guideCommentDto = commentService.createGuideComment(newData);

		return "redirect:/guides/" + guideId;
	}
}
