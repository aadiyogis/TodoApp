package org.learning.todolist.model;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.Instant;

@Slf4j
@Getter
@Setter
@Entity
@Table(name = "TODO")
public class ToDos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "TASK")
    private String task;

    @ManyToOne
    private Project project;

    @Column(name = "COMPLETED")
    private Boolean isCompleted;

    @Column(name = "CREATED_TIME")
    private Instant createdTime;

    @Column(name = "UPDATED_TIME")
    private Instant updatedTime;

}
