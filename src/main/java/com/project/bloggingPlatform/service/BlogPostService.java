package com.project.bloggingPlatform.service;

import com.project.bloggingPlatform.model.BlogPost;
import com.project.bloggingPlatform.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    public BlogPost createPost(BlogPost blogPost){
        return blogPostRepository.save(blogPost);
    }

    public BlogPost updatePost(Long id, BlogPost updatedPost){

        Optional<BlogPost>optionalBlogPost = blogPostRepository.findById(id);
        if(optionalBlogPost.isPresent()){
            BlogPost post = optionalBlogPost.get();
            post.setTitle(updatedPost.getTitle());
            post.setContent(updatedPost.getContent());
            post.setCategory(updatedPost.getCategory());
            post.setTags(updatedPost.getTags());
            BlogPost blogPost = blogPostRepository.save(post);
            return blogPost;
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Not Found");
        }

    }
    public boolean deleteBlog(Long id){

        Optional<BlogPost>optionalBlogPost = blogPostRepository.findById(id);
        if(optionalBlogPost.isPresent()){
            blogPostRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<BlogPost>getPost(Long id){
        return blogPostRepository.findById(id);
    }

    public List<BlogPost>getAllPosts(String term){
        if(term != null && !term.isEmpty()){
            return blogPostRepository.searchByTerm(term.toLowerCase());
        }
        return blogPostRepository.findAll();
    }

}
