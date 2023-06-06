package com.pakhomov.socialmedia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/friends")
@RequiredArgsConstructor
public class UserFriendController {

    @GetMapping
    public String showFriends() {
        return "List of friends";
    }

    @PostMapping("/{userId}")
    public String addFriend(@PathVariable Long userId) {
        return "Friendship invitation sent";
    }
}
