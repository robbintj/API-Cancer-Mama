package com.breast.exam_result.Repo;

import com.breast.exam_result.entities.AgeGroup;
import com.breast.exam_result.entities.Incidence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgeGroupRepo extends JpaRepository<AgeGroup, Long> {
}
