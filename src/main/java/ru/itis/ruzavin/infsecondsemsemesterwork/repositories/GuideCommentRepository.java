package ru.itis.ruzavin.infsecondsemsemesterwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.ruzavin.infsecondsemsemesterwork.models.GuideComment;

import java.util.List;

public interface GuideCommentRepository extends JpaRepository<GuideComment, Integer> {
	List<GuideComment> findAllByGuideId(Integer guideId);
}
