package com.code.issuestracker.repository;

import com.code.issuestracker.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Iterable<Project> findAllByCategory(String category);
}
