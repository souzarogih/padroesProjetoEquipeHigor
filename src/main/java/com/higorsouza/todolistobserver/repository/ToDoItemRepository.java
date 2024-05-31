package com.higorsouza.todolistobserver.repository;

import com.higorsouza.todolistobserver.model.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoItemRepository extends JpaRepository<ToDoItem, Long> {
}
