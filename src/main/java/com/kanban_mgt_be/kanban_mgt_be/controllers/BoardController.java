package com.kanban_mgt_be.kanban_mgt_be.controllers;

import com.kanban_mgt_be.kanban_mgt_be.dtos.TaskDto;
import com.kanban_mgt_be.kanban_mgt_be.requests.AddTaskRequest;
import com.kanban_mgt_be.kanban_mgt_be.requests.UpdateTaskRequest;
import com.kanban_mgt_be.kanban_mgt_be.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDto>> getTasks(){
        return new ResponseEntity<List<TaskDto>>(taskService.getTasks(), HttpStatus.OK);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<TaskDto> getTaskById(Long id){
        return new ResponseEntity<TaskDto>(taskService.getTaskById(id), HttpStatus.OK);
    }

    @PostMapping("/tasks")
    public ResponseEntity<String> createTask(@RequestBody AddTaskRequest addTaskRequest){
        return new ResponseEntity<String>(taskService.createTask(addTaskRequest), HttpStatus.CREATED);
    }

    @PutMapping("/tasks")
    public ResponseEntity<String> updateTask(@RequestBody UpdateTaskRequest updateTaskRequest, @RequestParam Long id){
        return new ResponseEntity<String>(taskService.updateTask(updateTaskRequest, id), HttpStatus.OK);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<String> deleteTask(@RequestParam Long id){
        return new ResponseEntity<String>(taskService.deleteTask(id), HttpStatus.OK);
    }
}
