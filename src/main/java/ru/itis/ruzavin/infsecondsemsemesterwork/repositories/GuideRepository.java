package ru.itis.ruzavin.infsecondsemsemesterwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.ruzavin.infsecondsemsemesterwork.models.Guide;

import java.util.List;

public interface GuideRepository extends JpaRepository<Guide, Integer> {
	List<Guide> findAllByTitleContains(String title);
}
