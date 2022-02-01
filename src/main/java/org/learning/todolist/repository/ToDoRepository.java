package org.learning.todolist.repository;

import org.learning.todolist.model.ToDos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDos, Long> {
}
