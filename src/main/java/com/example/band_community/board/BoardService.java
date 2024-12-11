package com.example.band_community.board;

import com.example.band_community.board.command.*;
import com.example.band_community.board.domain.Comment;
import com.example.band_community.board.domain.Post;
import com.example.band_community.board.form.CommentDto;
import com.example.band_community.board.form.PostDto;
import com.example.band_community.board.form.PostItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardStore boardStore;

    @Value("${spring.cloud.aws.cdn.url}")
    private String production;

    public Long createPost(CreatePost command) {
        return boardStore.savePost(command.getUsername(), new Post(command)).getId();
    }

    public Long changePost(ChangePost command){
        Post post = boardStore.findPost(command.getPostId());
        if(!post.getClubId().equals(command.getClubId())){
            return null;
        }
        return boardStore.saveEvent(post.changeContent(command)).getPostId();
    }

    public Long deletePost(DeletePost command){
        Post post = boardStore.findPost(command.getPostId());
        if(!post.getClubId().equals(command.getClubId())){
            return null;
        }
        return boardStore.saveEvent(post.delete(command)).getPostId();
    }

    public Long createComment(CreateComment command){
        Post post = boardStore.findPost(command.getPostId());
        command.setPost(post);

        if(!post.getClubId().equals(command.getClubId())){
            return null;
        }

        if(command.getBaseId()!=null){
            Comment base = boardStore.findComment(command.getBaseId());
            command.setBase(base);
        }
        return boardStore.saveComment(command.getUsername(), new Comment(command)).getId();
    }

    public Long changeComment(ChangeComment command){
        Comment comment = boardStore.findComment(command.getCommentId());

        if(!comment.getPost().getClubId().equals(command.getClubId())){
            return null;
        }
        if(!comment.getCreatedBy().equals(command.getUsername()) && !command.getAuthorized()){
            return null;
        }
        return boardStore.saveEvent(comment.changeContent(command)).getPostId();
    }

    public Long deleteComment(DeleteComment command){
        Comment comment = boardStore.findComment(command.getCommentId());

        if(!comment.getPost().getClubId().equals(command.getClubId())){
            return null;
        }
        if(!comment.getCreatedBy().equals(command.getUsername()) && !command.getAuthorized()){
            return null;
        }
        return boardStore.saveEvent(comment.delete(command)).getPostId();
    }

    public List<PostItemDto> getPosts(Long clubId, int pageNo, int pageSize){
        return boardStore.findPostListByClubId(clubId, pageNo, pageSize).stream()
                .map(p -> new PostItemDto(p, production + "/" + p.getImage())).toList();
    }

    public PostDto getPost(Long postId){
        Post post = boardStore.findPost(postId);

        return new PostDto(post, production + "/" + post.getImage());
    }

    public List<CommentDto> getComments(Long postId){
        List<CommentDto> result = new ArrayList<>();
        Map<Long, CommentDto> map = new HashMap<>();

        boardStore.findCommentListByPostId(postId)
                .forEach(c -> {
                    CommentDto temp = new CommentDto(c);
                    if(c.getBase()==null){
                        map.put(c.getId(), temp);
                        result.add(temp);
                    }else{
                        if(map.get(c.getBase().getId())==null){
                            CommentDto ghost = new CommentDto(c.getBase());
                            map.put(ghost.getId(), ghost);
                            result.add(ghost);
                        }

                        map.get(c.getBase().getId()).getComments().add(temp);
                    }
                });

        return result;
    }
}
