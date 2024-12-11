package com.example.band_community.board;

import com.example.band_community.board.form.CommentDto;
import com.example.band_community.board.form.PostItemDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/{clubId}/list")
    public ResponseEntity<?> getPosts(@PathVariable Long clubId, @RequestParam int pageNo){
        List<PostItemDto> list = boardService.getPosts(clubId, pageNo, 50);
        Map<String, Object> result = new HashMap<>();
        result.put("list", list);

        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<?> getPost(@PathVariable Long postId){
        return ResponseEntity.ok().body(boardService.getPost(postId));
    }

    @GetMapping("/{postId}/comments")
    public ResponseEntity<?> getComments(@PathVariable Long postId){
        List<CommentDto> list = boardService.getComments(postId);
        Map<String, Object> result = new HashMap<>();
        result.put("list", list);

        return ResponseEntity.ok().body(result);
    }

}
