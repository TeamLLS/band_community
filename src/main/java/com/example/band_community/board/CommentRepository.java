package com.example.band_community.board;

import com.example.band_community.board.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT c FROM Comment c left join fetch c.base " +
            "WHERE c.post.id=:postId AND c.deletedAt IS NULL ORDER BY c.createdAt ASC")
    public List<Comment> findAllByPostId(Long postId);
}
