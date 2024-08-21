package com.example.production_ready_features.controllers;

import com.example.production_ready_features.entities.PostEntity;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController  // This annotation marks the class as a REST controller,
// meaning it will handle HTTP requests and return JSON or other content types.
@RequestMapping(path = "/audit")  // Base path for all request mappings inside this controller.
public class AuditController {

    @Autowired  // Automatically inject the EntityManagerFactory bean from the Spring context.
    private EntityManagerFactory entityManagerFactory;

    // This endpoint returns a list of all revisions of a PostEntity.
    // It is mapped to the HTTP GET request with the URL pattern /audit/posts/{postId}.
    @GetMapping(path = "/posts/{postId}")
    List<PostEntity> getPostRevisions(@PathVariable Long postId) {
        // Create an AuditReader instance using the AuditReaderFactory. The AuditReader is used
        // to read the audit logs (revision history) for the given entity class (PostEntity).
        AuditReader reader = AuditReaderFactory.get(entityManagerFactory.createEntityManager());

        // Get a list of all revisions for the PostEntity with the specified postId.
        // Each revision represents a historical version of the entity.
        List<Number> revisions = reader.getRevisions(PostEntity.class, postId);

        // For each revision number, retrieve the state of the PostEntity at that specific revision.
        // This maps the list of revision numbers to a list of PostEntity instances.
        return revisions.stream()
                .map(revisionNumber -> reader.find(PostEntity.class, postId, revisionNumber)) // Fetch entity at each revision.
                .collect(Collectors.toList());  // Collect the results into a list.
    }

}
