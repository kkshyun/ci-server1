package com.example.devops.service;

import com.example.devops.domain.entity.Board;
import com.example.devops.exception.UserNotFoundException;
import com.example.devops.global.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BoardServiceTest {
    @InjectMocks
    private BoardService boardService;
    @Mock
    private BoardRepository boardRepository;

    @Test
    void deleteById() {
        // case 2: 있을 때
        // given
        Long id = 1L;
        BDDMockito.doNothing().when(boardRepository).deleteById(id);
        BDDMockito.given(boardRepository.findById(id))
                .willReturn(Optional.of(new Board(1L,null,null)));
        // when
        boardService.deleteById(id);

        // then
    }


    @Test
    void deleteByIdFail() {
        // case 1: id 이런 것이 없을 때
        Long id = 50000L;
        BDDMockito.given(boardRepository.findById(id))
                .willReturn(Optional.empty());

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            boardService.deleteById(id);
        });

    }
}