package ru.itis.ruzavin.infsecondsemsemesterwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.ruzavin.infsecondsemsemesterwork.models.Build;

import java.util.List;

public interface BuildRepository extends JpaRepository<Build, Integer> {
	List<Build> findAllByTitleContains(String title);
}
