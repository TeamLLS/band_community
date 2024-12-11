package com.example.band_community;

import com.example.band_community.board.CommentRepository;
import com.example.band_community.board.PostRepository;
import com.example.band_community.board.command.CreateComment;
import com.example.band_community.board.command.CreatePost;
import com.example.band_community.board.command.DeleteComment;
import com.example.band_community.board.domain.Comment;
import com.example.band_community.board.domain.Post;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class DummyUtil {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Transactional
    @PostConstruct
    public void makeDummy(){
        CreatePost command1 = new CreatePost("Dummy_userB", 1L, "hello1", "world", null, 2L, "임윤빈");
        CreatePost command2 = new CreatePost("Dummy_userA", 1L, "hello2", "apple", null, 1L, "허연준");
        CreatePost command3 = new CreatePost("Dummy_userA", 1L, "hello3", "banana", null, 1L, "허연준");
        Post post1 = postRepository.save(new Post(command1));
        Post post2 = postRepository.save(new Post(command2));
        Post post3 = postRepository.save(new Post(command3));


        CreateComment commandCmt1 = new CreateComment("Dummy_userA", 1L, post1.getId(), null, "comment1", 1L, "허연준");
        CreateComment commandCmt2 = new CreateComment("Dummy_userC", 1L, post1.getId(), null, "comment2", 3L, "권미르");
        CreateComment commandCmt3 = new CreateComment("Dummy_userD", 1L, post1.getId(), null, "comment3", 4L, "최은");
        commandCmt1.setPost(post1);
        commandCmt2.setPost(post1);
        commandCmt3.setPost(post1);
        Comment cmt1 = commentRepository.save(new Comment(commandCmt1));
        Comment cmt2 = commentRepository.save(new Comment(commandCmt2));
        Comment cmt3 = commentRepository.save(new Comment(commandCmt3));


        CreateComment commandCmt4 = new CreateComment("Dummy_userB", 1L, post2.getId(), null, "comment1", 2L, "임윤빈");
        commandCmt4.setPost(post2);
        Comment cmt4 = commentRepository.save(new Comment(commandCmt4));
        CreateComment commandCmt5 = new CreateComment("Dummy_userE", 1L, post2.getId(), cmt4.getId(), "comment1-1", 5L, "하도준");
        CreateComment commandCmt6 = new CreateComment("Dummy_userC", 1L, post2.getId(), cmt4.getId(), "comment1-2", 3L, "권미르");
        CreateComment commandCmt7 = new CreateComment("Dummy_userE", 1L, post2.getId(), cmt4.getId(), "comment1-3", 5L, "하도준");
        commandCmt5.setPost(post2);
        commandCmt6.setPost(post2);
        commandCmt7.setPost(post2);
        commandCmt6.setBase(cmt4);
        commandCmt5.setBase(cmt4);
        commandCmt7.setBase(cmt4);
        Comment cmt5 = commentRepository.save(new Comment(commandCmt5));
        Comment cmt6 = commentRepository.save(new Comment(commandCmt6));
        Comment cmt7 = commentRepository.save(new Comment(commandCmt7));


        CreateComment commandCmt8 = new CreateComment("Dummy_userD", 1L, post3.getId(), null, "comment1", 4L, "최은");
        CreateComment commandCmt9 = new CreateComment("Dummy_userC", 1L, post3.getId(), null, "comment2", 5L, "하도준");
        commandCmt8.setPost(post3);
        commandCmt9.setPost(post3);
        Comment cmt8 = commentRepository.save(new Comment(commandCmt8));
        Comment cmt9 = commentRepository.save(new Comment(commandCmt9));
        CreateComment commandCmt10 = new CreateComment("Dummy_userB", 1L, post3.getId(), cmt8.getId(), "comment1-1", 2L, "임윤빈");
        CreateComment commandCmt11 = new CreateComment("Dummy_userB", 1L, post3.getId(), cmt9.getId(), "comment2-1", 2L, "임윤빈");
        CreateComment commandCmt12 = new CreateComment("Dummy_userD", 1L, post3.getId(), cmt8.getId(), "comment1-2", 4L, "최은");
        commandCmt10.setPost(post3);
        commandCmt11.setPost(post3);
        commandCmt12.setPost(post3);
        commandCmt10.setBase(cmt8);
        commandCmt11.setBase(cmt9);
        commandCmt12.setBase(cmt8);
        Comment cmt10 = commentRepository.save(new Comment(commandCmt10));
        Comment cmt11 = commentRepository.save(new Comment(commandCmt11));
        Comment cmt12 = commentRepository.save(new Comment(commandCmt12));

        //cmt8.delete(new DeleteComment("Dummy_userD", 1L, 4L));
    }
}
