package com.example.band_community.board.event;

import com.example.band_community.core.Event;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Getter
@NoArgsConstructor
public abstract class BoardEvent extends Event {

    private Long postId;
    private Long memberId;

    public BoardEvent(String eventId, Long clubId, Long postId, Long memberId, String triggeredBy, Instant time) {
        super(eventId, clubId, triggeredBy, time);
        this.postId = postId;
        this.memberId = memberId;
    }
}
