/*
package com.code.issuestracker.service;

import com.code.issuestracker.entity.IssueCategory;
import com.code.issuestracker.repository.IssueCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IssueCategoryService {

    private IssueCategoryRepository issueCategoryRepository;

    public IssueCategory save(IssueCategory issueCategory){
        return issueCategoryRepository.save(issueCategory);
    }

    public IssueCategory findIssueCategoryByName(String name){
        return issueCategoryRepository.findIssueCategoriesByCategoryName(name);
    }

    public IssueCategory findIssueCategoryById(Long id){
        return issueCategoryRepository.findById(id).get();
    }

}
*/
