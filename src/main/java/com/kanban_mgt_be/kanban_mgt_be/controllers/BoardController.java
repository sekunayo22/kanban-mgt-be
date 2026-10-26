package com.kanban_mgt_be.kanban_mgt_be.controllers;

import com.kanban_mgt_be.kanban_mgt_be.dtos.BoardDto;
import com.kanban_mgt_be.kanban_mgt_be.dtos.TaskDto;
import com.kanban_mgt_be.kanban_mgt_be.requests.AddBoardRequest;
import com.kanban_mgt_be.kanban_mgt_be.requests.AddColumnRequest;
import com.kanban_mgt_be.kanban_mgt_be.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/boards")
    public ResponseEntity<List<BoardDto>> getBoards(){
        return new ResponseEntity<List<BoardDto>>(boardService.getBoards(), HttpStatus.OK);
    }

    @GetMapping("/boards/{id}")
    public ResponseEntity<BoardDto> getBoardById(Long id){
        return new ResponseEntity<BoardDto>(boardService.getBoardById(id), HttpStatus.OK);
    }

    @PostMapping("/boards")
    public ResponseEntity<BoardDto> createBoard(@RequestBody AddBoardRequest addBoardRequest){
        return new ResponseEntity<BoardDto>(boardService.createBoard(addBoardRequest), HttpStatus.CREATED);
    }

    @PostMapping("/boards/{id}/columns")
    public ResponseEntity<String> addColumnsToBoard(@RequestBody AddColumnRequest addColumnRequest){
        return new ResponseEntity<String>(boardService.addColumnsToBoard(addColumnRequest), HttpStatus.CREATED);
    }
}
