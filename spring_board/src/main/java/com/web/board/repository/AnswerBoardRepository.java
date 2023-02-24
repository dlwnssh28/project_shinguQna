package com.web.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.web.board.entity.AnswerBoard;

public interface AnswerBoardRepository extends JpaRepository<AnswerBoard, Integer> {
	
	@Query("select ab from AnswerBoard ab where ab.no= :no")
	AnswerBoard getBoardno(@Param("no") Integer no);
}
