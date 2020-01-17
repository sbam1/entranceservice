package com.softtech.entranceService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/hello")
    public String hello(@RequestParam String name) {
        return "Hello you " + name;
    }
    @RequestMapping("/")
    public String home() {
        return "Hello you";
    }
}
