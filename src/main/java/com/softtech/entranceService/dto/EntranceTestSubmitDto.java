package com.softtech.entranceService.dto;

import java.util.HashMap;
import java.util.Map;

public class EntranceTestSubmitDto {
    private long entranceTestRegistrationId;
    private Map<String, String> answers = new HashMap<>();

    public long getEntranceTestRegistrationId() {
        return entranceTestRegistrationId;
    }

    public void setEntranceTestRegistrationId(long entranceTestRegistrationId) {
        this.entranceTestRegistrationId = entranceTestRegistrationId;
    }

    public Map<String, String> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<String, String> answers) {
        this.answers = answers;
    }
}
