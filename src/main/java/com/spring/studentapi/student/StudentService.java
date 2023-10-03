package com.spring.studentapi.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    public List<Student> getAllStudents() {
        return List.of(new Student(
                UUID.randomUUID(),
                "Josh",
                "Kroenke",
                Gender.MALE,
                "josh@example.com"
        ),
        new Student(
                UUID.randomUUID(),
                "Selma",
                "Hayek",
                Gender.FEMALE,
                "shayek@example.com"
        ));
    }



}
