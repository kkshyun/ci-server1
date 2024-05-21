package com.example.devops.service;

import com.example.devops.domain.entity.Board;
import com.example.devops.domain.request.InsertBoardRequest;
import com.example.devops.exception.UserNotFoundException;
import com.example.devops.global.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardRepository boardRepository;
//
    @Override
    public void insertBoard(InsertBoardRequest insertBoardRequest) {
        boardRepository.save(insertBoardRequest.toEntity());
    }



    @Override
    public Board getBoardById(Long id){
        Optional<Board> byId = boardRepository.findById(id);
        if(byId.isEmpty()) throw new UserNotFoundException();
        return byId.get();
    }

    @Override
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }
}
