package com.softtech.entranceService.service;

import com.softtech.entranceService.model.EntranceTest;
import com.softtech.entranceService.repository.EntranceTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EntranceTestService {

    private EntranceTestRepository entranceTestRepository;

    @Autowired
    public EntranceTestService(EntranceTestRepository entranceTestRepository) {
        this.entranceTestRepository = entranceTestRepository;
    }


    public EntranceTest getEntranceTestByGrade(long grade) {
        Optional<EntranceTest> test = entranceTestRepository.findByGrade(grade);
        test.orElseThrow(() -> new RuntimeException("Entrance test does not exist"));
        return test.get();
    }
}
