package com.softtech.entranceService.dto;

public class EntranceTestRegistrationDto {
    private long studentId;
    private long entranceTestGrade;

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getEntranceTestGrade() {
        return entranceTestGrade;
    }

    public void setEntranceTestGrade(long entranceTestGrade) {
        this.entranceTestGrade = entranceTestGrade;
    }
}
