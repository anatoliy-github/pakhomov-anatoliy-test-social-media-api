package com.pakhomov.socialmedia.post;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue
    private Long id;

    private String caption;

    @Column(name = "file_link", nullable = false)
    private String fileLink;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;
}
