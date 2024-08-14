package com.example.production_ready_features.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.production_ready_features.entities.PostEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
