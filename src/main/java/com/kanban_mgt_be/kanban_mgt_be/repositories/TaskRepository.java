package com.kanban_mgt_be.kanban_mgt_be.repositories;

import com.kanban_mgt_be.kanban_mgt_be.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
