package com.pakhomov.socialmedia.friend;

import com.pakhomov.socialmedia.user.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "friends")
public class Friend {

    @ManyToMany
    @JoinColumn(name = "friend_one", nullable = false)
    private User FriendOne;

    @ManyToMany
    @JoinColumn(name = "friend_two", nullable = false)
    private User FriendTwo;

    private boolean friends;
}
