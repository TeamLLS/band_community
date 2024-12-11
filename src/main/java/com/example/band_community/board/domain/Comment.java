package com.example.band_community.board.domain;

import com.example.band_community.board.CommentRepository;
import com.example.band_community.board.command.ChangeComment;
import com.example.band_community.board.command.ChangePost;
import com.example.band_community.board.command.CreateComment;
import com.example.band_community.board.command.DeleteComment;
import com.example.band_community.board.event.CommentChanged;
import com.example.band_community.board.event.CommentDeleted;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment base;
    @NotNull
    private String createdBy;

    private Instant createdAt;
    private Instant deletedAt;

    @Lob
    private String content;

    @NotNull
    private Long memberId;

    private String memberName;

    public Comment(CreateComment command) {
        this.post = command.getPost();
        this.base = command.getBase();
        this.createdBy = command.getUsername();
        this.createdAt = Instant.now();
        this.content = command.getContent();
        this.memberId = command.getMemberId();
        this.memberName = command.getMemberName();
    }

    public CommentChanged changeContent(ChangeComment command){
        this.content = command.getContent();
        return new CommentChanged(command.getUsername(), this);
    }
    
    public CommentDeleted delete(DeleteComment command){
        this.content = null;
        this.deletedAt = Instant.now();
        return new CommentDeleted(command.getUsername(), this);
    }

}
