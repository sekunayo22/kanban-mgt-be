package com.kanban_mgt_be.kanban_mgt_be.repositories;

import com.kanban_mgt_be.kanban_mgt_be.models.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}
