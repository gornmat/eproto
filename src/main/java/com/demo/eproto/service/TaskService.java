package com.demo.eproto.service;

import com.demo.eproto.model.Task;
import com.demo.eproto.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    public void createTask(Task task) {
        repository.save(task);
    }

    public List<Task> findAllByIdTeacher(Long idTeacher) {
        return repository.findAllByIdTeacher(idTeacher);
    }

}
