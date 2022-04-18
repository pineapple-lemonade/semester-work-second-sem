package ru.itis.ruzavin.infsecondsemsemesterwork.services;

import org.springframework.web.multipart.MultipartFile;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.AddGuideDto;
import ru.itis.ruzavin.infsecondsemsemesterwork.dto.GuideDto;

import java.util.List;
import java.util.Optional;

public interface GuideService {
	List<GuideDto> getAllGuides();
	Optional<GuideDto> createGuide(MultipartFile pic, AddGuideDto addGuideDto, Integer userId);
	List<GuideDto> getAllGuidesByTitle(String title);
	Optional<GuideDto> getGuideById(Integer id);
}
