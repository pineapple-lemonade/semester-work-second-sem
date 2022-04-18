package ru.itis.ruzavin.infsecondsemsemesterwork.services.impl;

import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.AddBuildDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.BuildDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.GuideDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.exceptions.UserNotExistsException;
import ru.itis.ruzavin.infsecondsemsemesterwork.models.Build;
import ru.itis.ruzavin.infsecondsemsemesterwork.models.Guide;
import ru.itis.ruzavin.infsecondsemsemesterwork.models.User;
import ru.itis.ruzavin.infsecondsemsemesterwork.repositories.BuildRepository;
import ru.itis.ruzavin.infsecondsemsemesterwork.repositories.UserRepository;
import ru.itis.ruzavin.infsecondsemsemesterwork.services.BuildService;
import ru.itis.ruzavin.infsecondsemsemesterwork.util.CloudinaryHelper;
import ru.itis.ruzavin.infsecondsemsemesterwork.util.ImageHelper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BuildServiceImpl implements BuildService {

	private final BuildRepository buildRepository;

	private final UserRepository userRepository;

	private final ImageHelper imageHelper;

	private final CloudinaryHelper cloudinaryHelper;

	@Override
	public List<BuildDto> getAllBuilds() {
		return BuildDto.from(buildRepository.findAll());
	}

	@Override
	public Optional<BuildDto> createBuild(MultipartFile pic, AddBuildDto addBuildDto, Integer userId) {
		String url = imageHelper.createUrl(pic);

		User user = userRepository.findById(userId).orElseThrow(UserNotExistsException::new);

		Build newBuild = Build.builder()
				.date(LocalDateTime.now())
				.text(addBuildDto.getText())
				.title(addBuildDto.getTitle())
				.photoUrl(url)
				.user(user)
				.build();

		user.getBuilds().add(newBuild);

		Build build = buildRepository.save(newBuild);

		return Optional.of(BuildDto.from(newBuild));
	}

	@Override
	public List<BuildDto> getAllBuildsByTitle(String title) {
		return BuildDto.from(buildRepository.findAllByTitle(title));
	}
}
