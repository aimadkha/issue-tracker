package com.code.issuestracker.service;


import com.code.issuestracker.dto.ProjectDto;
import com.code.issuestracker.entity.Project;
import com.code.issuestracker.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
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



}
