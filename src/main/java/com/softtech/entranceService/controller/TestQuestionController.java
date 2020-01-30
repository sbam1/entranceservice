package com.softtech.entranceService.controller;

import com.softtech.entranceService.dto.QuestionDto;
import com.softtech.entranceService.model.TestQuestion;
import com.softtech.entranceService.service.TestQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestQuestionController {
    private TestQuestionService testQuestionService;

    @Autowired
    public TestQuestionController(TestQuestionService testQuestionService) {
        this.testQuestionService = testQuestionService;
    }


    @PostMapping("/question")
    public long saveQuestion(@RequestBody QuestionDto dto) {
        TestQuestion question = new TestQuestion(dto);
        return testQuestionService.saveTestQuestion(question, dto.getGrade());
    }
}
