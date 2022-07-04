package com.project.projectwebapp.service;

import java.util.Optional;

import com.project.projectwebapp.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    Optional<Student> getStudent(Integer studentId);
    Student setStudent(Student student);
    void deleteStudent(Integer studentId);
    Page<Student> getStudenci(Pageable pageable);
    Page<Student> searchByNazwisko(String nazwisko, Pageable pageable);
}

