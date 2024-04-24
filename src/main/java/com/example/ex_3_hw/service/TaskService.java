package com.example.ex_3_hw.service;

import com.example.ex_3_hw.aspects.TrackUserAction;
import com.example.ex_3_hw.model.Task;
import com.example.ex_3_hw.model.TaskStatus;
import com.example.ex_3_hw.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    @TrackUserAction
    public Task addTask(Task task) {
        task.setDateTimeCreation(LocalDateTime.now());
        return taskRepository.save(task);
    }
    @TrackUserAction
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
    public List<Task> getTasksByStatus(TaskStatus taskStatus) {
        return taskRepository.findByStatus(taskStatus);
    }
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public Task updateTaskStatus(Long id, Task task) {
        Optional<Task> taskReserve = taskRepository.findById(id);
        Task taskTemp = taskReserve.get();
        task.setStatus(taskTemp.getStatus());
        return taskRepository.save(task);
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }


}
