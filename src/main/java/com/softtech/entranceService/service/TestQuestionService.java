package com.softtech.entranceService.service;

import com.softtech.entranceService.model.EntranceTest;
import com.softtech.entranceService.model.TestQuestion;
import com.softtech.entranceService.repository.TestQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestQuestionService {
    private TestQuestionRepository testQuestionRepository;
    private EntranceTestService entranceTestService;

    @Autowired
    public TestQuestionService(TestQuestionRepository testQuestionRepository, EntranceTestService entranceTestService) {
        this.testQuestionRepository = testQuestionRepository;
        this.entranceTestService = entranceTestService;
    }

    public long saveTestQuestion(TestQuestion question, long grade) {
        EntranceTest test = entranceTestService.getEntranceTestByGrade(grade);
        question.setTest(test);
        TestQuestion saved = testQuestionRepository.save(question);
        return saved.getId();
    }


}
