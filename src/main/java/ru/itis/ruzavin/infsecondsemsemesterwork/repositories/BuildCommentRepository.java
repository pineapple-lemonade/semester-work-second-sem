package ru.itis.ruzavin.infsecondsemsemesterwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.ruzavin.infsecondsemsemesterwork.models.BuildComment;

import java.util.List;

public interface BuildCommentRepository extends JpaRepository<BuildComment, Integer> {
	List<BuildComment> findAllByBuildId(Integer id);
}
