package com.taskPrioritization.controller;

import com.taskPrioritization.Task;
import com.taskPrioritization.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task savedTask = taskService.saveTask(task);
        return ResponseEntity.ok(savedTask);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public List<Task> getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskService.getTaskById();
        return task.map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping("/{status}")
    public List<Task> getTaskByStatus(@PathVariable Status id) {
        Optional<Task> task = taskService.getTaskByStatus();
        return task.map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

}
