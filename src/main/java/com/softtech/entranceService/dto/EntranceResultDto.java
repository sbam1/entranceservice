package com.softtech.entranceService.dto;

public class EntranceResultDto {
    private long registrationId;
    private boolean passed;
    private int marks;

    public EntranceResultDto(long id, boolean passed, double marks) {
        this.registrationId = id;
        this.passed = passed;
        this.marks = (int) marks;
    }

    public EntranceResultDto() {
    }

    public long getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(long registrationId) {
        this.registrationId = registrationId;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
