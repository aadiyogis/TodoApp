package org.learning.todolist.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class TodoDto {

    private String task;
    private Boolean isCompleted;
    private Instant createdTime;
    private Instant updatedTime;
}
