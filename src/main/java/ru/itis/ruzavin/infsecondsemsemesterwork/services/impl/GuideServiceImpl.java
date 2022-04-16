package ru.itis.ruzavin.infsecondsemsemesterwork.services.impl;

import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.AddGuideDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.GuideDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.exceptions.UserNotExistsException;
import ru.itis.ruzavin.infsecondsemsemesterwork.models.Guide;
import ru.itis.ruzavin.infsecondsemsemesterwork.models.User;
import ru.itis.ruzavin.infsecondsemsemesterwork.repositories.GuideRepository;
import ru.itis.ruzavin.infsecondsemsemesterwork.repositories.UserRepository;
import ru.itis.ruzavin.infsecondsemsemesterwork.services.GuideService;
import ru.itis.ruzavin.infsecondsemsemesterwork.util.CloudinaryHelper;
import ru.itis.ruzavin.infsecondsemsemesterwork.util.ImageHelper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GuideServiceImpl implements GuideService {

	private final GuideRepository guideRepository;

	private final UserRepository userRepository;

	private final ImageHelper imageHelper;

	private final CloudinaryHelper cloudinaryHelper;

	@Override
	public List<GuideDto> getAllGuides() {
		return GuideDto.from(guideRepository.findAll());
	}

	@Override
	public Optional<GuideDto> createGuide(MultipartFile pic, AddGuideDto addGuideDto, Integer userId) {
		File file;
		String url;
		try {
			file = imageHelper.makeFile(pic);
			Map upload = CloudinaryHelper.getCloudinary().uploader()
					.upload(file, ObjectUtils.asMap("public_id", file.getName()));
			url = (String) upload.get("url");
			file.delete();
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}

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
}
