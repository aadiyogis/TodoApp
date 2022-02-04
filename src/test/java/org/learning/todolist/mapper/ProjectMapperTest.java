package org.learning.todolist.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.learning.todolist.dto.ProjectDto;
import org.learning.todolist.model.Project;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProjectMapperTest {
    private ProjectMapper projectMapper;
    private ProjectDto projectDto1;
    private Project project1;
    private static final String TASK_NAME = "Learn to be yourself";

    @BeforeEach
    void setUp() {
        projectMapper = new ProjectMapper();

        projectDto1 = new ProjectDto();
        projectDto1.setName(TASK_NAME);

        project1 = new Project();
        project1.setName(TASK_NAME);
    }

    @Test
    void mapProjectToProjectDto() {
        ProjectDto projectDto = projectMapper.mapProjectToProjectDto(project1);
        assertThat(projectDto).isNotNull();
        assertEquals(TASK_NAME, projectDto.getName());
    }

    @Test
    void mapProjectDtoToProject() {
        Project project = projectMapper.mapProjectDtoToProject(projectDto1);
        assertThat(project).isNotNull();
        assertThat(project.getName()).isEqualTo(TASK_NAME);
    }
}