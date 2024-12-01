package com.taskPrioritization.repository;

import com.taskPrioritization.model.Task;
import com.taskPrioritization.model.Task.Status;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(Status status);

}
