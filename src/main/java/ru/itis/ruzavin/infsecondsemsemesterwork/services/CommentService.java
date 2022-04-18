package ru.itis.ruzavin.infsecondsemsemesterwork.services;

import ru.itis.ruzavin.infsecondsemsemesterwork.dto.AddCommentDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.CommentDto;

import java.util.Optional;

public interface CommentService {
	Optional<CommentDto> createBuildComment(AddCommentDto addCommentDto);

	Optional<CommentDto> createGuideComment(AddCommentDto newData);
}
