package com.example.band_community.board.command;

import com.example.band_community.core.Command;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChangePost extends Command {

    private Long postId;
    private String title;
    private String content;
    private String image;

    public ChangePost(String username, Long clubId, Long postId, String title, String content, String image) {
        super(username, clubId);
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.image = image;
    }
}
