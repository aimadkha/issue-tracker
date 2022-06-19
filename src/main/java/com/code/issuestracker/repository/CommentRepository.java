package com.code.issuestracker.repository;

import com.code.issuestracker.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Long countById(Long id);
}
