package com.project.bloggingPlatform.repository;

import com.project.bloggingPlatform.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

    @Query("SELECT b FROM BlogPost b WHERE LOWER(b.title) LIKE %:term% OR LOWER(b.content) LIKE %:term% OR LOWER(b.category) LIKE %:term%")
    List<BlogPost> searchByTerm(@Param("term") String term);
}

