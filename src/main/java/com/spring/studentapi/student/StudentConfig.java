package com.spring.studentapi.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student Josh = new Student(
                    "Josh",
                    LocalDate.of(1999, Month.APRIL, 21),
                    "josh@example.com"
            );

            Student Alex = new Student(
                    "Alex",
                    LocalDate.of(1995, Month.AUGUST, 2),
                    "alex@example.com"
            );

            repository.saveAll(List.of(Josh, Alex));
        };
    }
}
