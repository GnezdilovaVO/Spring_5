package com.example.ex_3_hw.repository;

import com.example.ex_3_hw.model.Task;
import com.example.ex_3_hw.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(TaskStatus taskStatus);
}
