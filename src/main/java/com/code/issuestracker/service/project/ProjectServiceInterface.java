package com.code.issuestracker.service.project;

import com.code.issuestracker.entity.Project;

import java.util.Optional;

public interface ProjectServiceInterface {
    Project createProject(Project project);
    Optional<Project> getProjectById(Long projectId);
    Iterable<Project> getProjectsByCategory(String category );
    Iterable<Project> getProjects();
    void updateProject(Long projectId, Project project);
    void deleteProjectById(Long projectId);
    void deleteProjects();

}
