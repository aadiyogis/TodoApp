package org.learning.todolist.mapper;

import org.learning.todolist.dto.ProjectDto;
import org.learning.todolist.model.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    public ProjectDto mapProjectToProjectDto(Project project) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setName(project.getName());

        return projectDto;
    }

    public Project mapProjectDtoToProject(ProjectDto projectDto) {
        Project project = new Project();
        project.setName(projectDto.getName());

        return project;
    }
}
