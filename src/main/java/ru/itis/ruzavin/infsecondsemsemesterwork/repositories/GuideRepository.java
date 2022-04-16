package ru.itis.ruzavin.infsecondsemsemesterwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.ruzavin.infsecondsemsemesterwork.models.Guide;

public interface GuideRepository extends JpaRepository<Guide, Integer> {
}
