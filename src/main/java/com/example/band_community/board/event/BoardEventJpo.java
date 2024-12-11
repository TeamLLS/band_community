package com.example.band_community.board.event;

import com.example.band_community.core.Event;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;


@Getter
@Entity
@NoArgsConstructor
public class BoardEventJpo {

    @Id
    private String eventId;

    private Long clubId;

    private Long postId;

    private Long memberId;

    private String triggeredBy;
    private String eventType;

    @Lob
    private String payload;
    private Instant time;

    public BoardEventJpo(BoardEvent event) {
        this.eventId = event.getEventId();
        this.clubId = event.getClubId();
        this.postId = event.getPostId();
        this.memberId = event.getMemberId();
        this.triggeredBy = event.getTriggeredBy();
        this.eventType = event.typeName();
        this.payload = event.Payload();
        this.time = event.getTime();
    }

}
