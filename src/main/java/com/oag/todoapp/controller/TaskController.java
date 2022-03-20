package com.oag.todoapp.controller;

import com.oag.todoapp.dto.TaskInDTO;
import com.oag.todoapp.persistence.entity.Task;
import com.oag.todoapp.persistence.entity.TaskStatus;
import com.oag.todoapp.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskInDTO taskInDTO){

        return this.taskService.createTask(taskInDTO);
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return this.taskService.getAllTasks();
    }

    @GetMapping("/status/{status}")
    public List<Task> findAllByTaskStatus(@PathVariable("status")TaskStatus status){
        return this.taskService.findAllByTaskStatus(status);
    }

    @PatchMapping("/finish/{id}")
    public ResponseEntity<Void> finishTask(@PathVariable("id")Long id){
        this.taskService.finishTask(id);
        return ResponseEntity.noContent().build();
    }


}
