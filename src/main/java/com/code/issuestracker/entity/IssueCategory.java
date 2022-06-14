/*
package com.code.issuestracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="issue_category")
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class IssueCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category", orphanRemoval = true)
    private Set<Issue> issues;
}
*/
