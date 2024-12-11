package com.example.band_community.board.command;

import com.example.band_community.core.Command;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChangeComment extends Command {
    private Long commentId;
    private String content;
    private Boolean authorized;

    public ChangeComment(String username, Long clubId, Long commentId, String content, Boolean authorized) {
        super(username, clubId);
        this.commentId = commentId;
        this.content = content;
        this.authorized = authorized;
    }
}
