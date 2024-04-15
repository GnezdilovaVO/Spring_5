package com.example.ex_3_hw.controller;

import com.example.ex_3_hw.model.Task;
import com.example.ex_3_hw.model.TaskStatus;
import com.example.ex_3_hw.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public Task addTask(@RequestBody Task task){
        return taskService.addTask(task);
    }
    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus taskStatus){
        return taskService.getTasksByStatus(taskStatus);
    }
    @PutMapping("/tasks/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTaskStatus(id, task);
    }
    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

}
