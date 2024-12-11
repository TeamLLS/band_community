package com.example.band_community.board;

import com.example.band_community.board.domain.Comment;
import com.example.band_community.board.domain.Post;
import com.example.band_community.board.event.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BoardStore {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final BoardEventRepository boardEventRepository;

    public Post savePost(String username, Post post){
        Post saved = postRepository.save(post);
        saveEvent(new PostCreated(username, saved));
        return saved;
    }

    public Comment saveComment(String username, Comment comment){
        Comment saved = commentRepository.save(comment);
        saveEvent(new CommentCreated(username, saved));
        return saved;
    }

    public Post findPost(Long postId){
        return postRepository.findById(postId).orElseThrow();
    }

    public Comment findComment(Long commentId){
        return commentRepository.findById(commentId).orElseThrow();
    }

    public List<Post> findPostListByClubId(Long clubId, int pageNo, int pageSize){
        return postRepository.findAllByClubId(clubId, PageRequest.of(pageNo, pageSize)).getContent();
    }

    public List<Comment> findCommentListByPostId(Long postId){
        return commentRepository.findAllByPostId(postId);
    }

    public BoardEventJpo saveEvent(BoardEvent event){
        return boardEventRepository.save(new BoardEventJpo(event));
    }
}
