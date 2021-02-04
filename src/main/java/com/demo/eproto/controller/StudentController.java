package com.demo.eproto.controller;

import com.demo.eproto.model.Student;
import com.demo.eproto.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("student")
public class StudentController {

    private final StudentService service;

    @GetMapping
    public Student getStudent(Long id) {
        return service.getStudent(id);
    }

    @GetMapping("all")
    public List<Student> findAll() {
        return service.findAll();
    }

    @PutMapping
    public void createStudent(Student student) {
        service.createStudent(student);
    }

    @PostMapping
    public void updateStudent(Student student) {
        service.updateStudent(student);
    }

    @DeleteMapping
    public void deleteStudent(Long id) {
        service.deleteStudent(id);
    }

}
