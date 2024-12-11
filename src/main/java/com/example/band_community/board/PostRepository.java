package com.example.band_community.board;

import com.example.band_community.board.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p WHERE p.clubId=:clubId AND p.deletedAt IS NULL")
    public Page<Post> findAllByClubId(Long clubId, Pageable pageable);
}
