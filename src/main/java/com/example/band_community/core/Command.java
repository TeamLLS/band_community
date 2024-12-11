package com.example.band_community.core;


import com.example.band_community.board.command.*;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.NotNull;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CreatePost.class, name = "CreatePost"),
        @JsonSubTypes.Type(value = ChangePost.class, name = "ChangePost"),
        @JsonSubTypes.Type(value = DeletePost.class, name = "DeletePost"),
        @JsonSubTypes.Type(value = CreateComment.class, name = "CreateComment"),
        @JsonSubTypes.Type(value = ChangeComment.class, name = "ChangeComment"),
        @JsonSubTypes.Type(value = DeleteComment.class, name = "DeleteComment")
})
public abstract class Command {

    @NotNull
    private String username;

    private Long clubId;

    public Command() {
    }

    public Command(String username, Long clubId) {
        this.username = username;
        this.clubId = clubId;
    }

    public String getUsername() {
        return username;
    }

    public Long getClubId() {
        return clubId;
    }
}
