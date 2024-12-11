package com.example.band_community.external.kafka;


import com.example.band_community.board.BoardService;
import com.example.band_community.board.command.*;
import com.example.band_community.core.Command;
import com.example.band_community.core.UnknownCommandException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
@KafkaListener(topics = "community-topic", groupId = "community-consumer-group")
public class KafkaConsumerService {

    private final BoardService boardService;

    @KafkaHandler
    public void consumeCommand(CreatePost command){
        boardService.createPost(command);
    }
    @KafkaHandler
    public void consumeCommand(ChangePost command){
        boardService.changePost(command);
    }
    @KafkaHandler
    public void consumeCommand(DeletePost command){
        boardService.deletePost(command);
    }

    @KafkaHandler
    public void consumeCommand(CreateComment command){
        boardService.createComment(command);
    }
    @KafkaHandler
    public void consumeCommand(ChangeComment command){
        boardService.changeComment(command);
    }
    @KafkaHandler
    public void consumeCommand(DeleteComment command){
        boardService.deleteComment(command);
    }


    @KafkaHandler(isDefault = true)
    public void consume(Command command, Acknowledgment acknowledgment){
        throw new UnknownCommandException("알 수 없는 명령", command.getUsername());
    }
}
