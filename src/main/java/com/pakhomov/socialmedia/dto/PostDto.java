package com.pakhomov.socialmedia.dto;

import com.pakhomov.socialmedia.post.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private Status status;
    private LocalDateTime updated;
}
