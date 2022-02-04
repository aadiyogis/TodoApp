package org.learning.todolist.mapper;

import org.learning.todolist.dto.TodoDto;
import org.learning.todolist.model.ToDos;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {

    public TodoDto todosToTodoDto(ToDos toDos) {
        TodoDto todoDto = new TodoDto();
        todoDto.setTask(toDos.getTask());
        todoDto.setIsCompleted(toDos.getIsCompleted());
        todoDto.setCreatedTime(toDos.getCreatedTime());
        todoDto.setUpdatedTime(toDos.getUpdatedTime());

        return todoDto;
    }

    public ToDos todoDtoToTodos(TodoDto todoDto) {
        ToDos toDos = new ToDos();
        toDos.setCreatedTime(todoDto.getCreatedTime());
        toDos.setUpdatedTime(todoDto.getUpdatedTime());
        toDos.setIsCompleted(todoDto.getIsCompleted());
        toDos.setTask(todoDto.getTask());

        return toDos;
    }
}
