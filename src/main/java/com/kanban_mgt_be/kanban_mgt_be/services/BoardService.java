package com.kanban_mgt_be.kanban_mgt_be.services;

import com.kanban_mgt_be.kanban_mgt_be.dtos.BoardDto;
import com.kanban_mgt_be.kanban_mgt_be.dtos.TaskDto;
import com.kanban_mgt_be.kanban_mgt_be.mappers.BoardMapper;
import com.kanban_mgt_be.kanban_mgt_be.mappers.TaskMapper;
import com.kanban_mgt_be.kanban_mgt_be.models.Board;
import com.kanban_mgt_be.kanban_mgt_be.models.Task;
import com.kanban_mgt_be.kanban_mgt_be.repositories.BoardRepository;
import com.kanban_mgt_be.kanban_mgt_be.repositories.TaskRepository;
import com.kanban_mgt_be.kanban_mgt_be.requests.AddBoardRequest;
import com.kanban_mgt_be.kanban_mgt_be.requests.AddColumnRequest;
import com.kanban_mgt_be.kanban_mgt_be.requests.AddTaskRequest;
import com.kanban_mgt_be.kanban_mgt_be.requests.UpdateTaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private BoardMapper boardMapper;

    public List<BoardDto> getBoards() {
        return boardRepository.findAll().stream().map(board -> boardMapper.toDto(board)).toList();
    }

    public BoardDto getBoardById(Long id) {
        Board board = boardRepository.findById(id).orElseThrow();
        return boardMapper.toDto(board);
    }

    public BoardDto createBoard(AddBoardRequest addBoardRequest) {
        Board board = boardMapper.toEntity(addBoardRequest);
        boardRepository.save(board);
        return boardMapper.toDto(board);
    }

    public String addColumnsToBoard(AddColumnRequest addColumnRequest) {
        Board board = boardRepository.findById(addColumnRequest.getBoardId()).orElseThrow();
        List<String> updatedColumns = board.getColumns();
        if (updatedColumns == null) {
            updatedColumns = new ArrayList<>();
        }
        updatedColumns.add(addColumnRequest.getName());
        board.setColumns(updatedColumns);
        boardRepository.save(board);
        return "Successfully added new column to " + board.getName();
    }
}
