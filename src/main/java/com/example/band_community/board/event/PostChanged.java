package com.example.band_community.board.event;

import com.example.band_community.board.domain.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class PostChanged extends BoardEvent {

    private String title;
    private String content;
    private String image;

    public PostChanged(String username, Post post) {
        super(UUID.randomUUID().toString(), post.getClubId(),
                post.getId(), post.getMemberId(), username, Instant.now());
        this.title = post.getTitle();
        this.content = post.getContent();
        this.image = post.getImage();
    }
}
