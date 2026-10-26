package com.kanban_mgt_be.kanban_mgt_be.dtos;

import lombok.Data;

import java.util.List;

@Data
public class BoardDto {
    private Long id;
    private String name;
    private List<String> columns;
}
