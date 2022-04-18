package ru.itis.ruzavin.infsecondsemsemesterwork.services;

import org.springframework.web.multipart.MultipartFile;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.AddBuildDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.BuildDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface BuildService {
	List<BuildDto> getAllBuilds();
	Optional<BuildDto> createBuild(MultipartFile pic, AddBuildDto addBuildDto, Integer userId);
	List<BuildDto> getAllBuildsByTitle(String title);

	Optional<BuildDto> getBuildById(Integer buildId);

	Optional<UserDto> findUserByBuildId(Integer buildId);
}
