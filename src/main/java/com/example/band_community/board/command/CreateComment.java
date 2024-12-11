package com.example.band_community.board.command;

import com.example.band_community.board.domain.Comment;
import com.example.band_community.board.domain.Post;
import com.example.band_community.core.Command;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateComment extends Command {

    private Long postId;
    private Post post;
    private Long baseId;
    private Comment base;
    private String content;
    private Long memberId;
    private String memberName;

    public CreateComment(String username, Long clubId, Long postId, Long baseId, String content, Long memberId, String memberName) {
        super(username, clubId);
        this.postId = postId;
        this.baseId = baseId;
        this.content = content;
        this.memberId = memberId;
        this.memberName = memberName;
    }

    public void setPost(Post post){
        this.post = post;
    }

    public void setBase(Comment base){
        this.base = base;
    }
}
