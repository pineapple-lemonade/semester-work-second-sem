package ru.itis.ruzavin.infsecondsemsemesterwork.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.AddGuideDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.CommentDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.GuideDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.UserDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.exceptions.UserNotExistsException;
import ru.itis.ruzavin.infsecondsemsemesterwork.models.Guide;
import ru.itis.ruzavin.infsecondsemsemesterwork.models.User;
import ru.itis.ruzavin.infsecondsemsemesterwork.repositories.GuideCommentRepository;
import ru.itis.ruzavin.infsecondsemsemesterwork.repositories.GuideRepository;
import ru.itis.ruzavin.infsecondsemsemesterwork.repositories.UserRepository;
import ru.itis.ruzavin.infsecondsemsemesterwork.services.GuideService;
import ru.itis.ruzavin.infsecondsemsemesterwork.util.CloudinaryHelper;
import ru.itis.ruzavin.infsecondsemsemesterwork.util.ImageHelper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GuideServiceImpl implements GuideService {

	private final GuideRepository guideRepository;

	private final UserRepository userRepository;

	private final ImageHelper imageHelper;

	private final CloudinaryHelper cloudinaryHelper;

	private final GuideCommentRepository guideCommentRepository;

	@Override
	public List<GuideDto> getAllGuides() {
		return GuideDto.from(guideRepository.findAll());
	}

	@Override
	public Optional<GuideDto> createGuide(MultipartFile pic, AddGuideDto addGuideDto, Integer userId) {
		String url = imageHelper.createUrl(pic);

		User user = userRepository.findById(userId).orElseThrow(UserNotExistsException::new);

		Guide newGuide = Guide.builder()
				.date(LocalDateTime.now())
				.text(addGuideDto.getText())
				.title(addGuideDto.getTitle())
				.photoUrl(url)
				.user(user)
				.build();

		user.getGuides().add(newGuide);

		Guide guide = guideRepository.save(newGuide);

		return Optional.of(GuideDto.from(newGuide));
	}

	@Override
	public List<GuideDto> getAllGuidesByTitle(String title) {
		return GuideDto.from(guideRepository.findAllByTitleContains(title));
	}

	@Override
	public Optional<GuideDto> getGuideById(Integer id) {
		Guide guide = guideRepository.getById(id);
		return Optional.of(GuideDto.from(guide));
	}

	@Override
	public Optional<UserDto> findUserByGuideId(Integer guideId) {
		Guide guide = guideRepository.getById(guideId);
		User user = userRepository.getById(guide.getUser().getId());
		return Optional.of(UserDto.from(user));
	}

	@Override
	public List<CommentDto> getAllComments(Integer guideId) {
		return CommentDto.fromGuideComments(guideCommentRepository.findAllByGuideId(guideId));
	}
}
