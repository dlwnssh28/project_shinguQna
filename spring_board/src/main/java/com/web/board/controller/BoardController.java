package com.web.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.board.entity.Board;
import com.web.board.service.BoardService;

@CrossOrigin(origins = "http://3.39.62.224:3000")
@RestController
@RequestMapping("/api")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
/*
	@GetMapping("/board")
	public ResponseEntity<Map> getAllBoards(@RequestParam(value = "p_num", required=false) Integer p_num) {
		if (p_num == null || p_num <= 0) p_num = 1;
		
		return boardService.getPagingBoard(p_num);
	}
*/
	// get all board 
	@GetMapping("/board")
	public List<Board> getAllBoards() {
		return boardService.getAllBoard();
	}

	// create board
	@PostMapping("/board")
	public Board createBoard(@RequestBody Board board) {
		return boardService.createBoard(board);
	}

	// get board
	@GetMapping("/board/{no}")
	public ResponseEntity<Board> getBoardByNo(
			@PathVariable Integer no) {
		
		boardService.updateCounts(no); // increase count
		
		return boardService.getBoard(no);
	}

	// get board by studentid
	@GetMapping("/board/studentid/{studentid}")
	public ResponseEntity<List<Board>> getBoardByStudentId(
			@PathVariable Integer studentid) {
		
		return boardService.getBoardByStudentId(studentid);
	}
	
	// get board by division
		@GetMapping("/board/division/{divisioncode}")
		public ResponseEntity<List<Board>> getBoardByDivision(
				@PathVariable Integer divisioncode) {
			
			return boardService.getBoardByDivision(divisioncode);
		}

	// update board
	@PutMapping("/board/{no}")
	public ResponseEntity<Board> updateBoardByNo(
			@PathVariable Integer no, @RequestBody Board board){
		
		
		return boardService.updateBoard(no, board);
	}
	
	// delete board
	@DeleteMapping("/board/{no}")
	public ResponseEntity<Map<String, Boolean>> deleteBoardByNo(
			@PathVariable Integer no) {
		
		return boardService.deleteBoard(no);
	}
	
}