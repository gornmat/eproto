package com.demo.eproto.service;

import com.demo.eproto.model.Student;
import com.demo.eproto.model.Task;
import com.demo.eproto.model.User;
import com.demo.eproto.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository repository;
    private final StudentTaskService studentTaskService;

    public void createTask(User teacher, List<Student> students, Task task) {
        task.setIdTeacher(teacher.getId());
        var createdTask= repository.save(task);
        studentTaskService.assignTaskToStudent(students, createdTask);
    }

    public List<Task> findAllByIdTeacher(Long idTeacher) {
        return repository.findAllByIdTeacher(idTeacher);
    }

}
