package com.softtech.entranceService.repository;

import com.softtech.entranceService.model.EntranceTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntranceTestRepository extends JpaRepository<EntranceTest, Long> {

    Optional<EntranceTest> findByGrade(long grade);
}
