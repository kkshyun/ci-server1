package com.example.devops.service;

import com.example.devops.domain.entity.Board;
import com.example.devops.domain.entity.User;
import com.example.devops.domain.request.InsertBoardRequest;
import com.example.devops.exception.UserNotFoundException;
import com.example.devops.global.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BoardServiceImplTest {
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private BoardServiceImpl boardServiceImpl;
    @Test
    void insertBoard() {
        InsertBoardRequest req = new InsertBoardRequest("user name","board title");
        boardServiceImpl.insertBoard(req);
    }

    @Test
    @Transactional
    void getBoardById() {
        InsertBoardRequest req = new InsertBoardRequest("user name","board title");
        boardServiceImpl.insertBoard(req);
        InsertBoardRequest req2 = new InsertBoardRequest("user name2","board title2");
        boardServiceImpl.insertBoard(req2);
        assertEquals("user name",boardServiceImpl.getBoardById(1l).getUserName());
        assertEquals("board title2",boardServiceImpl.getBoardById(2l).getBoardTitle());
        assertThrows(UserNotFoundException.class, () -> {
            boardServiceImpl.getBoardById(123l);
        });
    }

    @Test
    void getAllBoards() {
        InsertBoardRequest req = new InsertBoardRequest("user name","board title");
        boardServiceImpl.insertBoard(req);
        InsertBoardRequest req2 = new InsertBoardRequest("user name2","board title2");
        boardServiceImpl.insertBoard(req2);
        assertEquals(2,boardServiceImpl.getAllBoards().size());
    }
}