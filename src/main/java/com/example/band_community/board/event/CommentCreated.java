package com.example.band_community.board.event;

import com.example.band_community.board.domain.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class CommentCreated extends BoardEvent {

    private String content;
    private String memberName;
    private Long commentId;
    private Long baseId;

    public CommentCreated(String username, Comment comment) {
        super(UUID.randomUUID().toString(), comment.getPost().getClubId(),
                comment.getPost().getId(), comment.getMemberId(), username, comment.getCreatedAt());
        this.content = comment.getContent();
        this.memberName = comment.getMemberName();
        this.commentId = comment.getId();
        this.baseId = comment.getBase()!=null?comment.getBase().getId():null;
    }
}
