package com.code.issuestracker.service.project;


import com.code.issuestracker.entity.Project;
import com.code.issuestracker.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImp implements ProjectServiceInterface {


    private ProjectRepository projectRepository;

    public ProjectServiceImp(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects(){
       return projectRepository.findAll();
    }

    public Project saveProject(Project project){
        return projectRepository.saveAndFlush(project);
    }

    public Optional<Project> getProject(Long id){
        return projectRepository.findById(id);
    }


    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Optional<Project> getProjectById(Long projectId) {
        return projectRepository.findById(projectId);
    }

    @Override
    public Iterable<Project> getProjectsByCategory(String category) {
        return projectRepository.findAllByCategory(category);
    }

    @Override
    public Iterable<Project> getProjects() {
        return projectRepository.findAll();
    }

    @Override
    public void updateProject(Long projectId, Project project) {
        projectRepository.findById(projectId).ifPresent(
                dbProject->{
                    dbProject.setName(project.getName());
                    dbProject.setDescription(project.getDescription());
                    dbProject.setCategory(project.getCategory());

                    projectRepository.save(dbProject);
                });
    }

    @Override
    public void deleteProjectById(Long projectId) {
        projectRepository.deleteById(projectId);
    }

    @Override
    public void deleteProjects() {
        projectRepository.deleteAll();
    }
}
