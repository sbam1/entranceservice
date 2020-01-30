package com.softtech.entranceService.model;

import javax.persistence.*;

@Entity
public class EntranceTestRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private double marks;
    private boolean passed;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_student_id", referencedColumnName = "studentId")
    private Student student;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_test_id", referencedColumnName = "id")
    private EntranceTest entranceTest;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public EntranceTest getEntranceTest() {
        return entranceTest;
    }

    public void setEntranceTest(EntranceTest entranceTest) {
        this.entranceTest = entranceTest;
    }
}
