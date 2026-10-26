package com.kanban_mgt_be.kanban_mgt_be.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="tasks")
@Data
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private List<String> subtasks;
    private String status;

    @ManyToOne
    @JoinColumn(name="board_id")
    private Board board;
}
