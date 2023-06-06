package com.pakhomov.socialmedia.controller;

import com.pakhomov.socialmedia.config.JwtService;
import com.pakhomov.socialmedia.dto.PostDto;
import com.pakhomov.socialmedia.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserPostController {

    private final PostService postService;
    private final JwtService jwtService;

    @GetMapping
    public String showNewsFeed(@PathVariable Long userId) {
        //Получить посты всех, на кого подписан текущий user по его user_id
        return "News feed of user with id " + userId;
    }

    @GetMapping("/{userId}/post")
    public List<PostDto> getPostByUserId(@PathVariable Long userId) {
        return postService.findAllByUserId(userId);
    }

    @PostMapping("/post")
    public ResponseEntity<PostDto> createPost(@RequestHeader HttpHeaders headers,
                                              @RequestBody PostDto postDto) {
        String authHeader = headers.get("authorization").toString();
        String token = authHeader.substring(7);
        String userEmail = jwtService.extractUsername(token);
        return new ResponseEntity<>(postService.createPost(userEmail, postDto), HttpStatus.CREATED);
    }

    @PutMapping("/post/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestHeader HttpHeaders headers,
                                              @RequestBody PostDto postDto) {
        String authHeader = headers.get("authorization").toString();
        String token = authHeader.substring(7);
        String userEmail = jwtService.extractUsername(token);
        PostDto updatedPost = postService.updatePost(userEmail, postDto);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }

    @DeleteMapping("/post/{postId}")
    public ResponseEntity<String> deletePost(@RequestHeader HttpHeaders headers,
                           @PathVariable Long postId) {
        String authHeader = headers.get("authorization").toString();
        String token = authHeader.substring(7);
        String userEmail = jwtService.extractUsername(token);
        postService.deletePost(userEmail, postId);
        return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);
    }

}
