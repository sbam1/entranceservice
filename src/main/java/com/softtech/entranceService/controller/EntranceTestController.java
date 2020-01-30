package com.softtech.entranceService.controller;

import com.softtech.entranceService.dto.EntranceResultDto;
import com.softtech.entranceService.dto.EntranceTestSubmitDto;
import com.softtech.entranceService.dto.TakeExamDto;
import com.softtech.entranceService.service.EntranceTestRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class EntranceTestController {
    private EntranceTestRegistrationService entranceTestRegistrationService;

    @Autowired
    public EntranceTestController(EntranceTestRegistrationService entranceTestRegistrationService) {
        this.entranceTestRegistrationService = entranceTestRegistrationService;
    }


    @GetMapping("/takeexam")
    public TakeExamDto takeExam(@RequestParam long id) {
        return entranceTestRegistrationService.takeExam(id);
    }

    @PostMapping("/submit")
    public EntranceResultDto submitTestResult(@RequestBody EntranceTestSubmitDto testSubmitDto) {
        return entranceTestRegistrationService.generateResult(testSubmitDto);
    }

    public EntranceResultDto getEntranceResult(@RequestParam String email, @RequestParam int grade) {
        return entranceTestRegistrationService.getEntranceResult(email, grade);
    }
}
