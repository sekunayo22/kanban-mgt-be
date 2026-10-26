package com.kanban_mgt_be.kanban_mgt_be.requests;

import lombok.Data;

import java.util.List;

@Data
public class AddBoardRequest {
    private String name;
    private List<String> columns;
}
