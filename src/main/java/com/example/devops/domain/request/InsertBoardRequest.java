package com.example.devops.domain.request;

import com.example.devops.domain.entity.Board;

public record InsertBoardRequest(String userName, String title) {
    public Board toEntity() {
        return Board.builder()
                .boardTitle(title)
                .userName(userName)
                .build();
    }
}
