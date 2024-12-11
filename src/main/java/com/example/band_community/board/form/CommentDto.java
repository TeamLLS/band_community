package com.example.band_community.board.form;

import com.example.band_community.board.domain.Comment;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CommentDto {
    private Long id;

    private Long postId;

    private String createdBy;

    private Instant createdAt;

    private String content;

    private Long memberId;

    private String memberName;

    private List<CommentDto> comments;

    public CommentDto(Comment comment) {
        this.id = comment.getId();
        this.postId = comment.getPost().getId();
        this.createdBy = comment.getCreatedBy();
        this.createdAt = comment.getCreatedAt();
        this.content = comment.getContent();
        this.memberId = comment.getMemberId();
        this.memberName = comment.getMemberName();
        this.comments = new ArrayList<>();
    }

}
