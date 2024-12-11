package com.example.band_community.board.event;

import com.example.band_community.board.domain.Post;
import com.example.band_community.core.Event;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;


@Getter
@NoArgsConstructor
public class PostCreated extends BoardEvent {

    private String content;
    private String memberName;

    public PostCreated(String username, Post post) {
        super(UUID.randomUUID().toString(), post.getClubId(), post.getId(),
                post.getMemberId(), post.getCreatedBy(), post.getCreatedAt());
        this.content = post.getContent();
        this.memberName = post.getMemberName();
    }
}