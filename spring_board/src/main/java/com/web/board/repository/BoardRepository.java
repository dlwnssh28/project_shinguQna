package com.web.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.web.board.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {
	
	public final static String SELECT_BOARD_LIST_PAGED = ""
			+ "SELECT "
			+ "no,"
			+ "division,"
			+ "department,"
			+ "category,"
			+ "title,"
			+ "contents,"
			+ "answer,"
			+ "answercontents,"
			+ "studentid,"
			+ "createdtime"
			+ " FROM board WHERE 0 < no "
			+ "ORDER BY no DESC LIMIT ?1, ?2";
	
	
	@Query(value = SELECT_BOARD_LIST_PAGED, nativeQuery = true)
	List<Board> findFromTo(
			final Integer objectStartNum,
			final Integer objectEndNum);
}