package com.softtech.entranceService.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class EntranceTest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long grade;

    @OneToMany(mappedBy = "test")
    private List<TestQuestion> questions = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getGrade() {
        return grade;
    }

    public void setGrade(long grade) {
        this.grade = grade;
    }

    public List<TestQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<TestQuestion> questions) {
        this.questions = questions;
    }
}
