package com.code.issuestracker.service;

import com.code.issuestracker.entity.Issue;
import com.code.issuestracker.repository.IssueRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class IssueService {

    private IssueRepository issueRepository;

    public List<Issue> getAllIssue(){
        return (List<Issue>) issueRepository.findAll();
    }


    public void deleteIssue(Long id){
        Long countById = issueRepository.countById(id);
        if (countById == null || countById == 0){
         /*   throw new UsernameNotFoundException("could not found a user with id : "+ id);*/
            log.error("could not found a issue with id "+ id);
        }
        issueRepository.deleteById(id);
    }

    public Issue save(Issue issue) {
        /*return issueRepository.save(issue);*/
        return issueRepository.saveAndFlush(issue);
    }

    public Issue getIssueById(Long id){
        return issueRepository.findById(id).get();
    }



}
