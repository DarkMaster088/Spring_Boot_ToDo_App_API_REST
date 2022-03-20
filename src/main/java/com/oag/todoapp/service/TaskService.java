package com.oag.todoapp.service;

import com.oag.todoapp.dto.TaskInDTO;
import com.oag.todoapp.mapper.TaskInDTOToTask;
import com.oag.todoapp.persistence.entity.Task;
import com.oag.todoapp.persistence.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskInDTOToTask mapper;

    public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Task createTask(TaskInDTO taskInDTO){
        Task task = mapper.map(taskInDTO);
        return this.repository.save(task);
    }
}
