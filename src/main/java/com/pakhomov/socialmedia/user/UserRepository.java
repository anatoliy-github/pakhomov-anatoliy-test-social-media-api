package com.pakhomov.socialmedia.user;

import java.util.Optional;

import com.pakhomov.socialmedia.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    Optional<User> findById(Long id);


}
