package com.code.issuestracker.controller;


import com.code.issuestracker.entity.Issue;
import com.code.issuestracker.entity.Project;
import com.code.issuestracker.service.project.ProjectServiceImp;
import com.code.issuestracker.util.IssueNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProjectController {


    private ProjectServiceImp projectService;

    public ProjectController(ProjectServiceImp projectService) {
        this.projectService = projectService;
    }

    @PostMapping("project")
    ResponseEntity<Project> saveProject(@RequestBody Project project){
        return new ResponseEntity<>(projectService.saveProject(project), HttpStatus.CREATED);
    }

    @GetMapping("/project")
    ResponseEntity<?> findAllUsers(){
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    @PutMapping("project/{id}")
    Project updateProject(@RequestBody Project newProject, @PathVariable Long id){
        Project project = projectService.getProject(id).get();
        project.setName(newProject.getName());
        project.setDescription(newProject.getDescription());
        project.setCategory(newProject.getCategory());
        project.setPriority(newProject.getPriority());
        return projectService.saveProject(project);
    }

    @GetMapping(path = "/project/{id}")
    Project getProject(@PathVariable Long id)
    {
        return projectService.getProject(id).orElseThrow(()->new IssueNotFoundException(id));
    }

    @PostMapping("/project/{id}")
    Issue addIssueToProject(@RequestBody Issue issue, @PathVariable Long id){
        List<Issue> issues = new ArrayList<>();
        issues.add(issue);
        Project project = projectService.getProject(id).get();
        project.setIssues(issues);
        projectService.saveProject(project);
        return issue;
    }

    @DeleteMapping("project/{id}")
    void deleteProject(@PathVariable("id") Long id){
        projectService.deleteProjectById(id);
    }


}
