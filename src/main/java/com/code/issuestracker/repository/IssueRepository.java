package com.code.issuestracker.repository;


import com.code.issuestracker.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {
    Long countById(Long id);
}
