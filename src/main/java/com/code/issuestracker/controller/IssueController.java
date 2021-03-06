package com.code.issuestracker.controller;


import com.code.issuestracker.entity.Comment;
import com.code.issuestracker.entity.Issue;
import com.code.issuestracker.service.issue.IssueService;
import com.code.issuestracker.util.IssueNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
@Slf4j
public class IssueController {

    private IssueService issueService;
    /*private IssueCategoryService categoryService;*/

    public IssueController(IssueService issueService/*, IssueCategoryService categoryService*/) {
        this.issueService = issueService;
        /*this.categoryService = categoryService;*/
    }



    @GetMapping("/issue")
     ResponseEntity<?> findAllUsers(){
        return ResponseEntity.ok(issueService.getAllIssue());
    }

    @GetMapping(path = "/issue/{id}")
     Issue getIssue(@PathVariable Long id)
    {
        return issueService.getIssueById(id).orElseThrow(()->new IssueNotFoundException(id));
    }

    @PostMapping("/issue")
     ResponseEntity<?> saveIssue(@RequestBody Issue issue){
        /*if(categoryService.findIssueCategoryByName(issue.getCategory().getCategoryName()) != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }*/
        /*user.setRole(Role.USER);*/
        /*IssueCategory issueCategory = categoryService.findIssueCategoryByName("Bug");
        issue.setCategory(issueCategory);*/
        /*Long x = Long.valueOf(1);
        IssueCategory issueCategory = categoryService.findIssueCategoryById(x);*/
    /*    issue.setCategory(issueCategory);*/
        log.info("test save method");
        return new ResponseEntity<>(issueService.save(issue), HttpStatus.CREATED);
    }

    // need to customize and finish it
    @PutMapping("/issue/{id}")
    public Issue updateIssue(@RequestBody Issue newIssue, @PathVariable Long id){

        return issueService.save(newIssue);
    }

    @DeleteMapping("/issue/{id}")
    void deleteIssue(@PathVariable Long id){
        issueService.deleteIssue(id);
    }


    @PostMapping("/issue/{id}")
    ResponseEntity<?> addCommentToIssue(@RequestBody Comment comment, @PathVariable Long id){
        List<Comment> comments = new ArrayList<>();
        Issue issue = issueService.getIssueById(id).get();
        comments.add(comment);
        issue.setComments(comments);
        return new ResponseEntity<>(issueService.save(issue), HttpStatus.CREATED);

    }




}
