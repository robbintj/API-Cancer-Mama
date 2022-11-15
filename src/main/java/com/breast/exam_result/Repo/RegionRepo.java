package com.breast.exam_result.Repo;


import com.breast.exam_result.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepo extends JpaRepository<Region, Long> {
}
