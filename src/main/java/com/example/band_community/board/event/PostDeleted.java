package com.example.band_community.board.event;

import com.example.band_community.board.domain.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class PostDeleted extends BoardEvent{

    public PostDeleted(String username, Post post) {
        super(UUID.randomUUID().toString(), post.getClubId(), post.getId(),
                post.getMemberId(), username, post.getDeletedAt());
    }
}
