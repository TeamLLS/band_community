package com.example.band_community.board.command;

import com.example.band_community.core.Command;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreatePost extends Command {

    private String title;
    private String content;
    private String image;
    private Long memberId;
    private String memberName;

    public CreatePost(String username, Long clubId, String title, String content, String image, Long memberId, String memberName) {
        super(username, clubId);
        this.title = title;
        this.content = content;
        this.image = image;
        this.memberId = memberId;
        this.memberName = memberName;
    }
}
