package com.demo.eproto.service;

import com.demo.eproto.model.Student;
import com.demo.eproto.model.StudentTask;
import com.demo.eproto.model.Task;
import com.demo.eproto.repository.StudentTaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentTaskService {

    private final StudentTaskRepository repository;

    public void assignTaskToStudent(List<Student> students, Task task) {
        List<StudentTask> studentTasks = new ArrayList<>();
        students.forEach(student ->
                studentTasks.add(
                        new StudentTask(task.getId(), student.getId(), task.getDescription(), task.getDueDate())
                )
        );
        repository.saveAll(studentTasks);
    }

}
