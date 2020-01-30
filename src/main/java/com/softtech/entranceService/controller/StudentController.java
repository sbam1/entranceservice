package com.softtech.entranceService.controller;

import com.softtech.entranceService.dto.StudentDto;
import com.softtech.entranceService.model.Student;
import com.softtech.entranceService.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/studentbymail")
    public Student getStudentByEmail(@RequestParam String email) {
        return studentService.getStudentByEmail(email);
    }

    @PostMapping("/student")
    public long saveStudent(@RequestBody StudentDto studentDto) {
        return studentService.saveStudent(studentDto);
    }
}
