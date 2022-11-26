package com.web.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.web.board.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {
	/*
	public final static String SELECT_BOARD_LIST_PAGED = ""
			+ "SELECT "
			+ "no,"
			+ "divisioncode,"
			+ "category,"
			+ "title,"
			+ "contents,"
			+ "addboard,"
			+ "answer,"
			+ "answercontents,"
			+ "studentid,"
			+ "createdtime,"
			+ "counts"
			+ " FROM board WHERE 0 < no "
			+ "ORDER BY no DESC LIMIT ?1, ?2";
	
	
	@Query(value = SELECT_BOARD_LIST_PAGED, nativeQuery = true)
	List<Board> findFromTo(
			final Integer objectStartNum,
			final Integer objectEndNum);		
	*/
	
	// increase count
	@Modifying    
	@Query("UPDATE Board b SET b.counts = b.counts + 1 WHERE no = ?1")    
	int updateCounts(Integer no);
	
}

