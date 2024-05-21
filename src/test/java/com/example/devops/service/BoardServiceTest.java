package com.example.devops.service;

import com.example.devops.domain.entity.Board;
import com.example.devops.exception.UserNotFoundException;
import com.example.devops.global.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceTest {
    @Autowired
    private BoardService boardService;
    @Autowired
    private BoardRepository boardRepository;

    @Test
    void deleteById() {
        // case 2: 있을 때
        // given
        Board save = boardRepository.save(new Board(null, "test", "test"));
        Long id = save.getId();

        // when
        boardService.deleteById(id);

        // then
        assertEquals(0, boardRepository.findAll().size());
    }


    @Test
    void deleteByIdFail() {
        // case 1: id 이런 것이 없을 때
        Long id = 80000L;

        assertThrows(IllegalArgumentException.class, () -> {
            boardService.deleteById(id);
        });
    }
}