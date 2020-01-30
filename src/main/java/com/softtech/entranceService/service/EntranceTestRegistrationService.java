package com.softtech.entranceService.service;

import com.softtech.entranceService.dto.EntranceResultDto;
import com.softtech.entranceService.dto.EntranceTestRegistrationDto;
import com.softtech.entranceService.dto.EntranceTestSubmitDto;
import com.softtech.entranceService.dto.TakeExamDto;
import com.softtech.entranceService.model.EntranceTest;
import com.softtech.entranceService.model.EntranceTestRegistration;
import com.softtech.entranceService.model.Student;
import com.softtech.entranceService.model.TestQuestion;
import com.softtech.entranceService.repository.EntranceTestRegistrationRepository;
import com.softtech.entranceService.repository.EntranceTestRepository;
import com.softtech.entranceService.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class EntranceTestRegistrationService {
    private EntranceTestRegistrationRepository entranceTestRegistrationRepository;
    private StudentRepository studentRepository;
    private EntranceTestRepository entranceTestRepository;

    @Autowired
    public EntranceTestRegistrationService(EntranceTestRegistrationRepository entranceTestRegistrationRepository, StudentRepository studentRepository, EntranceTestRepository entranceTestRepository) {
        this.entranceTestRegistrationRepository = entranceTestRegistrationRepository;
        this.studentRepository = studentRepository;
        this.entranceTestRepository = entranceTestRepository;
    }

    public long registration(EntranceTestRegistrationDto registrationDto) {
        EntranceTestRegistration test = new EntranceTestRegistration();
        Optional<Student> student = studentRepository.findById(registrationDto.getStudentId());
        student.orElseThrow(() -> new RuntimeException("Student does not exist"));

        Optional<EntranceTest> entranceTest = entranceTestRepository.findByGrade(registrationDto.getEntranceTestGrade());
        entranceTest.orElseThrow(() -> new RuntimeException("Entrance test does not exist"));

        test.setStudent(student.get());
        test.setEntranceTest(entranceTest.get());

        EntranceTestRegistration registered = entranceTestRegistrationRepository.save(test);
        return registered.getId();
    }

    public TakeExamDto takeExam(long id) {
        Optional<EntranceTestRegistration> test = entranceTestRegistrationRepository.findById(id);
        test.orElseThrow(() -> new RuntimeException("Entrance test registration does not exist"));
        return new TakeExamDto(test.get());
    }

    public EntranceResultDto generateResult(EntranceTestSubmitDto testSubmitDto) {
        AtomicInteger correctAnswer = new AtomicInteger();
        Optional<EntranceTestRegistration> test = entranceTestRegistrationRepository.findById(testSubmitDto.getEntranceTestRegistrationId());
        test.orElseThrow(() -> new RuntimeException("Entrance test registration does not exist"));

        Map<String, String> resultMap = test.get().getEntranceTest().getQuestions().stream().collect(Collectors.toMap(TestQuestion::getQuestion, TestQuestion::getAnswer));

        testSubmitDto.getAnswers().forEach((key, value) -> {
            if (value.equalsIgnoreCase(resultMap.get(key))) {
                correctAnswer.getAndIncrement();
            }
        });
        test.get().setMarks(correctAnswer.intValue() * 10);
        test.get().setPassed(correctAnswer.intValue() > 6);
        EntranceTestRegistration saved = entranceTestRegistrationRepository.save(test.get());
        return new EntranceResultDto(saved.getId(), saved.isPassed(), saved.getMarks());
    }

    public EntranceResultDto getEntranceResult(String email, int grade) {
        Optional<EntranceTestRegistration> result = entranceTestRegistrationRepository.findByEntranceTest_GradeAndStudent_Email(grade, email);
        result.orElseThrow(() -> new RuntimeException("Entrance test registration does not exist"));
        return new EntranceResultDto(result.get().getId(), result.get().isPassed(), result.get().getMarks());
    }
}
