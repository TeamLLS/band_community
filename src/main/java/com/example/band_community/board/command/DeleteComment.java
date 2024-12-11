package com.example.band_community.board.command;

import com.example.band_community.core.Command;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeleteComment extends Command {
    private Long commentId;
    private Boolean authorized;

    public DeleteComment(String username, Long clubId, Long commentId, Boolean authorized) {
        super(username, clubId);
        this.commentId = commentId;
        this.authorized = authorized;
    }
}
