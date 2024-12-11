package com.example.band_community.board.event;

import com.example.band_community.board.domain.Comment;
import com.example.band_community.board.domain.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class CommentDeleted extends BoardEvent{
    public CommentDeleted(String username, Comment comment) {
        super(UUID.randomUUID().toString(), comment.getPost().getClubId(),
                comment.getPost().getId(), comment.getMemberId(), username, comment.getDeletedAt());
    }
}
