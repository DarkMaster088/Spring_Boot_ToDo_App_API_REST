package com.oag.todoapp.persistence.repository;

import com.oag.todoapp.persistence.entity.Task;
import com.oag.todoapp.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByTaskStatus(TaskStatus status);
}