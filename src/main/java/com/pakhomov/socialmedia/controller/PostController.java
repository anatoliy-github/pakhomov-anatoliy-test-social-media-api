package com.pakhomov.socialmedia.controller;

import com.pakhomov.socialmedia.dto.PostDto;
import com.pakhomov.socialmedia.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Long postId) {
        PostDto postDto = postService.findPostById(postId);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }
}
