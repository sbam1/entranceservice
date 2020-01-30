package com.softtech.entranceService.dto;

import com.softtech.entranceService.model.EntranceTestRegistration;
import com.softtech.entranceService.model.TestQuestion;

import java.util.ArrayList;
import java.util.List;

public class TakeExamDto {
    private long testRegistrationId;
    private List<TestQuestion> questions = new ArrayList<>();

    public TakeExamDto(EntranceTestRegistration entranceTestRegistration) {
        this.testRegistrationId = entranceTestRegistration.getId();
        this.questions = entranceTestRegistration.getEntranceTest().getQuestions();
    }

    public TakeExamDto() {
    }

    public long getTestRegistrationId() {
        return testRegistrationId;
    }

    public void setTestRegistrationId(long testRegistrationId) {
        this.testRegistrationId = testRegistrationId;
    }

    public List<TestQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<TestQuestion> questions) {
        this.questions = questions;
    }
}
