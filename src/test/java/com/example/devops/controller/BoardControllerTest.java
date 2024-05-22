package com.example.devops.controller;

import com.example.devops.domain.entity.Board;
import com.example.devops.service.BoardServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcResultMatchersDsl;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(BoardController.class)
class BoardControllerTest {

    @MockBean
    private BoardServiceImpl boardService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllBoards() throws Exception {
        // given
        // boardService.getAll() list[3]
//         TDD : test driven design
//         DDD : domain driven design
//         BDD : business driven design
//         monolithic : 하나로 묶어서 개발하는 거
//         MSA service : 나눠서 개발하는 거
//         EDA : event driven architecture
        BDDMockito.given(boardService.getAllBoards())
                .willReturn(List.of(
                        new Board(1l,"test1","test1"),
                        new Board(2l,"test2","test2"),
                        new Board(3l,"test3","test3")
                ));
        // when & then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/boards"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1)) // 검증
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(3))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print()); // 하는 거
    }

    @Test
    void insertBoard() {
    }

    @Test
    void getBoardById() {
    }
}