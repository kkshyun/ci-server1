package com.example.devops.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BOARDS")
@Builder
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_ID")
    private Long id;
    @Column(name = "USER_NAME") @Setter
    private String userName;
    @Column(name = "BOARD_TITLE") @Setter
    private String boardTitle;
}
