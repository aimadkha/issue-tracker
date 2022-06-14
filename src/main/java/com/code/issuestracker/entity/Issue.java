package com.code.issuestracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "issue")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Issue implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

/*    @ManyToOne
    @JoinColumn(name="category_id", nullable = true)
    private IssueCategory category;*/

    @Column(name="type")
    private String type;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="priority")
    private String priority;

    @Column(name="date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name="last_updated")
    @UpdateTimestamp
    private Date lastUpdated;

}
