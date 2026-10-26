package com.kanban_mgt_be.kanban_mgt_be.requests;

import lombok.Data;

@Data
public class AddColumnRequest {
    private Long boardId;
    private String name;
}
