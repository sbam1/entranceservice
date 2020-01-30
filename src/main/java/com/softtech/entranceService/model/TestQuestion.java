package com.softtech.entranceService.model;

import com.softtech.entranceService.dto.QuestionDto;

import javax.persistence.*;

@Entity
public class TestQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String question;
    private String optionOne;
    private String optionTwo;
    private String optionThree;
    private String optionFour;
    private String answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_entrance_test")
    private EntranceTest test;

    public TestQuestion(QuestionDto dto) {
        this.question = dto.getQuestion();
        this.optionOne = dto.getOptionOne();
        this.optionTwo = dto.getOptionTwo();
        this.optionThree = dto.getOptionThree();
        this.optionFour = dto.getOptionFour();
        this.answer = dto.getAnswer();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptionOne() {
        return optionOne;
    }

    public void setOptionOne(String optionOne) {
        this.optionOne = optionOne;
    }

    public String getOptionTwo() {
        return optionTwo;
    }

    public void setOptionTwo(String optionTwo) {
        this.optionTwo = optionTwo;
    }

    public String getOptionThree() {
        return optionThree;
    }

    public void setOptionThree(String optionThree) {
        this.optionThree = optionThree;
    }

    public String getOptionFour() {
        return optionFour;
    }

    public void setOptionFour(String optionFour) {
        this.optionFour = optionFour;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public EntranceTest getTest() {
        return test;
    }

    public void setTest(EntranceTest test) {
        this.test = test;
    }
}
