package com.example.band_community.board.event;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardEventRepository extends JpaRepository<BoardEventJpo, String> {
}
