package com.web.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.board.model.AnswerBoard;

public interface AnswerBoardRepository extends JpaRepository<AnswerBoard, Integer> {

}
