package com.kanban_mgt_be.kanban_mgt_be.dtos;

import lombok.Data;

import java.util.List;

@Data
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private List<String> subtasks;
    private String status;
    private BoardDto boardDto;
}
