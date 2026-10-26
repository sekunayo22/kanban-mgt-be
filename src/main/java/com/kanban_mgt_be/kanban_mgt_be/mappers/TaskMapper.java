package com.kanban_mgt_be.kanban_mgt_be.mappers;

import com.kanban_mgt_be.kanban_mgt_be.dtos.TaskDto;
import com.kanban_mgt_be.kanban_mgt_be.models.Task;
import com.kanban_mgt_be.kanban_mgt_be.requests.AddTaskRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task toEntity(TaskDto taskDto);
    Task toEntity(AddTaskRequest addTaskRequest);
    TaskDto toDto(Task task);
}
