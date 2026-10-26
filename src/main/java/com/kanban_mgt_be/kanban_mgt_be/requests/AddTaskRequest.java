package com.kanban_mgt_be.kanban_mgt_be.requests;

import lombok.Data;

import java.util.List;

@Data
public class AddTaskRequest {
    private String title;
    private String description;
    private List<String> subtasks;
    private String status;
    private Long boardId;
}
