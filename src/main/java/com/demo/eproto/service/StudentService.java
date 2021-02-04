package com.demo.eproto.service;

import com.demo.eproto.exception.StudentNotFoundException;
import com.demo.eproto.model.Student;
import com.demo.eproto.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public Student getStudent(Long id) {
        return repository.findById(id).orElseThrow(StudentNotFoundException::new);
    }

    public List<Student> findAll() {
        return repository.findAll();
    }

    public void createStudent(Student student) {
        repository.save(student);
    }

    public void updateStudent(Student student) {
    repository.save(student);
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }


}
