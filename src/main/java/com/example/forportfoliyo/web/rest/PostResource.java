package com.example.forportfoliyo.web.rest;

import com.example.forportfoliyo.model.Post;
import com.example.forportfoliyo.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostResource {

    private final PostService postService;

    public PostResource(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public ResponseEntity getAll(){
        List<Post> postList = postService.findAll();
        return ResponseEntity.ok(postList);
    }
}
