package com.demo.eproto.service;

import com.demo.eproto.model.Student;
import com.demo.eproto.model.User;
import com.demo.eproto.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public Student getStudentByIdParent(Long idParent) {
        return repository.getStudentByIdParent(idParent).orElse(new Student());
    }

    public void save(Student student) {
        repository.save(student);
    }
}
