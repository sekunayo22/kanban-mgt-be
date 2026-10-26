package com.kanban_mgt_be.kanban_mgt_be.services;

import com.kanban_mgt_be.kanban_mgt_be.dtos.TaskDto;
import com.kanban_mgt_be.kanban_mgt_be.mappers.TaskMapper;
import com.kanban_mgt_be.kanban_mgt_be.models.Task;
import com.kanban_mgt_be.kanban_mgt_be.repositories.TaskRepository;
import com.kanban_mgt_be.kanban_mgt_be.requests.AddTaskRequest;
import com.kanban_mgt_be.kanban_mgt_be.requests.UpdateTaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskMapper taskMapper;

    public List<TaskDto> getTasks() {
        return taskRepository.findAll().stream().map(task -> taskMapper.toDto(task)).toList();
    }

    public TaskDto getTaskById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow();
        return taskMapper.toDto(task);
    }

    public String deleteTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow();
        taskRepository.delete(task);
        return "Successfully deleted the task";
    }

    public String updateTask(UpdateTaskRequest updateTaskRequest, Long id) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setStatus(updateTaskRequest.getStatus());
        task.setDescription(updateTaskRequest.getDescription());
        task.setTitle(updateTaskRequest.getTitle());
        task.setSubstasks(updateTaskRequest.getSubstasks());
        taskRepository.save(task);
        return "Successfully deleted the task";
    }

    public String createTask(AddTaskRequest addTaskRequest) {
        Task task = taskMapper.toEntity(addTaskRequest);
        taskRepository.save(task);
        return "Successfully created a new task";
    }
}
