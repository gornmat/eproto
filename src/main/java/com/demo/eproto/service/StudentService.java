package com.demo.eproto.service;

import com.demo.eproto.model.Student;
import com.demo.eproto.model.User;
import com.demo.eproto.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public List<Student> getStudentsByClazz(String clazz) {
        return repository.getAllByClazz(clazz);
    }

    public Student getStudentForParent(User user) {
        return repository.getStudentByIdParent(user.getId())
                .orElse(new Student(user.getId(), user.getClazz()));
    }

    public void save(Student student) {
        repository.save(student);
    }
}
