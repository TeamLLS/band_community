package com.example.band_community.board.domain;


import com.example.band_community.board.command.*;
import com.example.band_community.board.event.PostChanged;
import com.example.band_community.board.event.PostDeleted;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Getter
@Entity
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private Long clubId;

    @NotNull
    private String createdBy;

    private Instant createdAt;
    private Instant deletedAt;

    private String title;
    @Lob
    private String content;

    private String image;

    @NotNull
    private Long memberId;

    private String memberName;

    public Post(CreatePost command) {
        this.clubId = command.getClubId();
        this.createdBy = command.getUsername();
        this.createdAt = Instant.now();
        this.title = command.getTitle();
        this.content = command.getContent();
        this.image = command.getImage();
        this.memberId = command.getMemberId();
        this.memberName = command.getMemberName();
    }

    public PostChanged changeContent(ChangePost command){
        if(command.getTitle()!=null){
            this.title = command.getTitle();
        }
        if(command.getContent()!=null){
            this.content = command.getContent();
        }
        if(command.getImage()!=null){
            this.image = command.getImage();
        }
        return new PostChanged(command.getUsername(), this);
    }

    public PostDeleted delete(DeletePost command){
        this.title = null;
        this.content = null;
        this.image = null;
        this.deletedAt = Instant.now();
        return new PostDeleted(command.getUsername(), this);
    }
}
