package com.taskPrioritization.service;

import com.taskPrioritization.repository.TaskRepository;
import com.taskPrioritization.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.taskPrioritization.model.Task.Status;

import java.util.List;
import java.util.Optional;

// business logic that interact with repository
@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public List<Task> getTasksByStatus(Status status) {
        return taskRepository.findByStatus(status);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }



} 
