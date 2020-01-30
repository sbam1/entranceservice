package com.softtech.entranceService.repository;

import com.softtech.entranceService.model.EntranceTestRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntranceTestRegistrationRepository extends JpaRepository<EntranceTestRegistration, Long> {

    Optional<EntranceTestRegistration> findByEntranceTest_GradeAndStudent_Email(int grade, String email);
}
