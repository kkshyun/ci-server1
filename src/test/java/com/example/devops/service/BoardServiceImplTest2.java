package com.example.devops.service;

import com.example.devops.domain.entity.Board;
import com.example.devops.domain.request.InsertBoardRequest;
import com.example.devops.global.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BoardServiceImplTest2 {
    @Mock
    private BoardRepository boardRepository;
    @InjectMocks
    private BoardServiceImpl boardService;

    @Test
    void getById() {
        Board board = new Board(1l, "test", "test");
        BDDMockito.given(boardRepository.findById(1l))
                .willReturn(Optional.of(board));


        Board byId = boardService.getBoardById(1l);


//        행위 검증
        Mockito.verify(boardRepository, Mockito.times(1)).findById(1l);
//        상태 검증
        assertEquals("test", byId.getUserName());
        assertEquals("test", byId.getBoardTitle());
        assertNotNull(byId.getId());
    }
    @Test
    void getByIdNotExist() {
        BDDMockito.given(boardRepository.findById(1l)).willReturn(Optional.empty());
        assertThrows(IllegalArgumentException.class, ()->{
            boardService.getBoardById(1l);
        });
        Mockito.verify(boardRepository,Mockito.times(1)).findById(1l);

    }

    @Test
    void getAll() {

        BDDMockito.given(boardRepository.findAll()).willReturn(
                List.of(new Board(1l,"test", "test"),new Board(2l,"test", "test")));

        List<Board> all = boardService.getAllBoards();

        assertEquals(2, all.size());
        assertEquals("test", all.get(1).getUserName());
        Mockito.verify(boardRepository).findAll();
    }

//    @Test
//    void saveBoard() {
//        InsertBoardRequest request = new InsertBoardRequest("test", "test");
//        Board entity = request.toEntity();
//        BDDMockito.given(boardRepository.save(entity))
//                .willReturn(entity);
//
//        boardService.insertBoard(request);
//
//        Mockito.verify(boardRepository, Mockito.times(1)).save(entity);
//    }
}