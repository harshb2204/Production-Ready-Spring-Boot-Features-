package com.example.production_ready_features.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "posts")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Audited

public class PostEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String title;


    private String description;

    @PrePersist
    void beforeSave(){

    }

    @PreUpdate
    void beforeUpdate(){

    }
    @PreRemove
    void beforeDelete(){

    }


}
