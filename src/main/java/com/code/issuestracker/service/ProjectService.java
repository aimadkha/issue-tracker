package com.code.issuestracker.service;


import com.code.issuestracker.entity.Project;
import com.code.issuestracker.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class ProjectService {

    private ProjectRepository projectRepository;

    List<Project> getAllProjects(){
       return projectRepository.findAll();
    }

    Project saveProject(Project project){
        return projectRepository.saveAndFlush(project);
    }

    Optional<Project> getProject(Long id){
        return projectRepository.findById(id);
    }

}
