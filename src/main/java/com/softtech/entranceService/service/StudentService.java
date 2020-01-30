package com.softtech.entranceService.service;

import com.softtech.entranceService.dto.StudentDto;
import com.softtech.entranceService.model.Student;
import com.softtech.entranceService.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public long saveStudent(StudentDto studentDto) {
        Student student = new Student(studentDto);
        Student savedStudent = studentRepository.save(student);
        return savedStudent.getStudentId();
    }

    public Student getStudentByEmail(String email) {
       return studentRepository.findByEmail(email);
    }
}
