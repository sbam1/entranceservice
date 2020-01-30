package com.softtech.entranceService.repository;

import com.softtech.entranceService.model.TestQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestQuestionRepository extends JpaRepository<TestQuestion, Long> {
}
