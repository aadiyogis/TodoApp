package org.learning.todolist.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.learning.todolist.dto.TodoDto;
import org.learning.todolist.model.ToDos;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TodoMapperTest {
    private TodoMapper todoMapper;
    private TodoDto todoDto1;
    private ToDos toDos1;
    private static final String TASK = "Do Swadhyay";

    @BeforeEach
    void setUp() {
        todoMapper = new TodoMapper();
        todoDto1 = new TodoDto();
        todoDto1.setTask(TASK);
        todoDto1.setIsCompleted(false);
        Instant now = Instant.now();
        todoDto1.setUpdatedTime(now);
        todoDto1.setCreatedTime(now);

        toDos1 = new ToDos();
        toDos1.setTask(TASK);
        toDos1.setCreatedTime(now);
        toDos1.setUpdatedTime(now);
        toDos1.setIsCompleted(false);
    }

    @Test
    void todosToTodoDto() {
        TodoDto todoDto = todoMapper.todosToTodoDto(toDos1);
        assertThat(todoDto.getTask()).isEqualTo(TASK);
    }

    @Test
    void todoDtoToTodos() {
        ToDos toDos = todoMapper.todoDtoToTodos(todoDto1);
        assertThat(toDos.getTask()).isEqualTo(TASK);
    }
}