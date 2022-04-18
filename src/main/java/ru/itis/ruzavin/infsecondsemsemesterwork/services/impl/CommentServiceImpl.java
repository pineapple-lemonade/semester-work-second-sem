package ru.itis.ruzavin.infsecondsemsemesterwork.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.AddCommentDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.CommentDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.models.*;
import ru.itis.ruzavin.infsecondsemsemesterwork.repositories.*;
import ru.itis.ruzavin.infsecondsemsemesterwork.services.CommentService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
	private final UserRepository userRepository;

	private final BuildRepository buildRepository;

	private final GuideRepository guideRepository;

	private final BuildCommentRepository buildCommentRepository;

	private final GuideCommentRepository guideCommentRepository;

	@Override
	public Optional<CommentDto> createBuildComment(AddCommentDto addCommentDto) {
		User user = userRepository.getById(addCommentDto.getUserId());
		Build build = buildRepository.getById(addCommentDto.getTopicId());

		BuildComment comment = BuildComment.builder()
				.text(addCommentDto.getText())
				.build(build)
				.user(user)
				.build();

		user.getBuildComments().add(comment);
		build.getBuildComment().add(comment);

		BuildComment savedComment = buildCommentRepository.save(comment);

		return Optional.of(CommentDto.from(savedComment));
	}

	@Override
	public Optional<CommentDto> createGuideComment(AddCommentDto newData) {
		User user = userRepository.getById(newData.getUserId());
		Guide guide = guideRepository.getById(newData.getTopicId());

		GuideComment comment = GuideComment.builder()
				.text(newData.getText())
				.guide(guide)
				.user(user)
				.build();

		user.getGuideComments().add(comment);
		guide.getGuideComment().add(comment);

		GuideComment savedComment = guideCommentRepository.save(comment);

		return Optional.of(CommentDto.from(savedComment));
	}
}
