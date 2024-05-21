package com.example.devops.controller;

import com.example.devops.domain.entity.Board;
import com.example.devops.domain.request.InsertBoardRequest;
import com.example.devops.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping
    public void insertBoard(@RequestBody InsertBoardRequest req) {
        boardService.insertBoard(req);
    }

    @GetMapping
    public List<Board> getAllBoards() {
        return boardService.getAllBoards();
    }

    @GetMapping("/{id}")
    public Board getBoardById(@PathVariable("id")Long id){
        return boardService.getBoardById(id);
    }
}
