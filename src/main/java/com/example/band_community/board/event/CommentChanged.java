package com.example.band_community.board.event;

import com.example.band_community.board.domain.Comment;
import com.example.band_community.core.Event;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class CommentChanged extends BoardEvent {

    private String content;

    public CommentChanged(String username, Comment comment) {
        super(UUID.randomUUID().toString(), comment.getPost().getClubId(),
                comment.getPost().getId(), comment.getMemberId(), username, Instant.now());
        this.content = comment.getContent();
    }
}
