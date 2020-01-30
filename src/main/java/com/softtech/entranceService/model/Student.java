package com.softtech.entranceService.model;

import com.softtech.entranceService.dto.StudentDto;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long studentId;

    private String email;

    private String firstName;

    private String lastName;

    private String address;

    @OneToOne(mappedBy = "student")
    private EntranceTestRegistration registration;

    public Student(StudentDto studentDto) {
        this.email = studentDto.getEmail();
        this.firstName = studentDto.getFirstName();
        this.lastName = studentDto.getLastName();
        this.address = studentDto.getAddress();
    }

    public Student() {
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
