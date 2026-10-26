package com.kanban_mgt_be.kanban_mgt_be.mappers;

import com.kanban_mgt_be.kanban_mgt_be.dtos.BoardDto;
import com.kanban_mgt_be.kanban_mgt_be.dtos.TaskDto;
import com.kanban_mgt_be.kanban_mgt_be.models.Board;
import com.kanban_mgt_be.kanban_mgt_be.models.Task;
import com.kanban_mgt_be.kanban_mgt_be.requests.AddBoardRequest;
import com.kanban_mgt_be.kanban_mgt_be.requests.AddTaskRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoardMapper {
    Board toEntity(BoardDto boardDto);
    Board toEntity(AddBoardRequest addBoardRequest);
    BoardDto toDto(Board board);
}
