package com.project.bloggingPlatform.controller;

import com.project.bloggingPlatform.model.BlogPost;
import com.project.bloggingPlatform.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/Blog")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @PostMapping("/posts")
    public ResponseEntity<BlogPost>createPost(@RequestBody BlogPost blogPost){

        return new ResponseEntity<>(blogPostService.createPost(blogPost), HttpStatus.CREATED);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<?>updatePost(@PathVariable Long id, @RequestBody BlogPost blogPost){

        try{
            BlogPost blogPost1 = blogPostService.updatePost(id, blogPost);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }

    @DeleteMapping("posts/{id}")
    public ResponseEntity<?>deleteBlog(@PathVariable Long id){

        if(blogPostService.deleteBlog(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<?>getBlog(@PathVariable Long id){
        return blogPostService.getPost(id)
                .map(post->new ResponseEntity<>(post,HttpStatus.OK))
                .orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/posts")
    public ResponseEntity<List<BlogPost>>getAllPosts(@RequestParam(value = "term",required = false) String term){
        List<BlogPost>blogPosts = blogPostService.getAllPosts(term);
        return new ResponseEntity<>(blogPosts,HttpStatus.OK);
    }





}
