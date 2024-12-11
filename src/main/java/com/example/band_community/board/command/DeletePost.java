package com.example.band_community.board.command;

import com.example.band_community.core.Command;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeletePost extends Command {
    private Long postId;

    public DeletePost(String username, Long clubId, Long postId) {
        super(username, clubId);
        this.postId = postId;
    }
}
