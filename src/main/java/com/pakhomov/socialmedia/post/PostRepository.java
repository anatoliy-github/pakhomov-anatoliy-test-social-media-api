package com.pakhomov.socialmedia.post;

import com.pakhomov.socialmedia.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByUserId(Long id);

    User findUserById(Long id);
}
