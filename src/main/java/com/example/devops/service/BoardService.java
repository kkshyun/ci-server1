package com.example.devops.service;

import com.example.devops.domain.entity.Board;
import com.example.devops.domain.request.InsertBoardRequest;

import java.util.List;

public interface BoardService {
    public void insertBoard(InsertBoardRequest insertBoardRequest);

    public Board getBoardById(Long id);

    public List<Board> getAllBoards();
    void deleteById(Long id);
}
