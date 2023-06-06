package com.pakhomov.socialmedia.post;

import com.pakhomov.socialmedia.dto.PostDto;
import com.pakhomov.socialmedia.user.User;
import com.pakhomov.socialmedia.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostDto createPost(String userEmail, PostDto postDto) {
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        Post post = mapToEntity(postDto);
        post.setUser(user);
        Post savedPost = postRepository.save(post);
        return mapToDto(savedPost);
    }

    public PostDto findPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        return mapToDto(post);
    }

    public List<PostDto> findAllByUserId(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        List<Post> posts = postRepository.findAllByUserId(id);
        List<PostDto> postsDto = new ArrayList<>();
        for (Post p : posts) {
            postsDto.add(mapToDto(p));
        }
        return postsDto;
    }

    public PostDto updatePost(String userEmail, PostDto postDto) {
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        Post post = mapToEntity(postDto);
        User postUser = postRepository.findUserById(postDto.getId());
        if(!user.getEmail().equals(postUser.getEmail())) {
            throw new RuntimeException("You can\'t edit this post");
        }
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());

        Post updatedPost =postRepository.save(post);
        return mapToDto(updatedPost);
    }

    public void deletePost(String userEmail, Long postId) {
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        if(!userEmail.equals(user.getEmail())) {
            throw new RuntimeException("You can\'t delete this post");
        }
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        postRepository.delete(post);
    }

    private PostDto mapToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setStatus(post.getStatus());
        postDto.setUpdated(post.getUpdated());
        return postDto;
    }

    private Post mapToEntity(PostDto postDto) {
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setStatus(Status.PUBLISH);
        post.setUpdated(LocalDateTime.now());
        return post;
    }
}
