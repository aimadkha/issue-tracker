package com.code.issuestracker.service;

import com.code.issuestracker.entity.Comment;
import com.code.issuestracker.entity.Issue;
import com.code.issuestracker.repository.CommentRepository;
import com.code.issuestracker.util.IssueNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentService {

    private CommentRepository commentRepository;


    public List<Comment> getAllComment(){
        return (List<Comment>) commentRepository.findAll();
    }


    public void deleteComment(Long id){
        Long countById = commentRepository.countById(id);
        if (countById == null || countById == 0){
            throw new IssueNotFoundException(id);
        }
        commentRepository.deleteById(id);
    }

    public Comment save(Comment comment) {
        /*return issueRepository.save(issue);*/
        return commentRepository.saveAndFlush(comment);
    }

    public Optional<Comment> getCommentById(Long id){
        return commentRepository.findById(id);
    }


}
