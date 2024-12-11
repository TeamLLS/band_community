package com.example.band_community.board.form;

import com.example.band_community.board.domain.Post;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class PostDto {

    private Long id;

    private Long clubId;

    private String createdBy;

    private Instant createdAt;

    private String title;
    private String content;

    private String image;

    private Long memberId;

    private String memberName;

    public PostDto(Post post, String image) {
        this.id = post.getId();
        this.clubId = post.getClubId();
        this.createdBy = post.getCreatedBy();
        this.createdAt = post.getCreatedAt();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.image = image;
        this.memberId = post.getMemberId();
        this.memberName = post.getMemberName();
    }
}
