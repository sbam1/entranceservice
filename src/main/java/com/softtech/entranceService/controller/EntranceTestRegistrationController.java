package com.softtech.entranceService.controller;

import com.softtech.entranceService.dto.EntranceTestRegistrationDto;
import com.softtech.entranceService.service.EntranceTestRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entranceservice")
public class EntranceTestRegistrationController {

    private EntranceTestRegistrationService service;

    @Autowired
    public EntranceTestRegistrationController(EntranceTestRegistrationService service) {
        this.service = service;
    }


    @PostMapping("register")
    public long register(EntranceTestRegistrationDto dto) {
        return service.registration(dto);
    }
}
