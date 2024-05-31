package com.higorsouza.todolistobserver.repository;

import com.higorsouza.todolistobserver.model.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
}
