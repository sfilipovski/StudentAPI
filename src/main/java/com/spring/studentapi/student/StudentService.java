package com.spring.studentapi.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        if(studentRepository.findStudentByEmail(student.getEmail()).isPresent())
            throw new IllegalStateException("Email is already taken");

        return this.studentRepository.save(student);
    }

    public Student deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Student with id:"+id+" doesn't exist"));

        studentRepository.delete(student);
        return student;
    }

    @Transactional
    public void updateStudent(Long id, String name, String email) {
        Student student = studentRepository.findById(id).orElseThrow(IllegalStateException::new);

        if(name != null && !name.isEmpty()) student.setName(name);
        if(email != null && !email.isEmpty()) student.setEmail(email);
    }
}
