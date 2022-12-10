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

import com.web.board.model.AnswerBoard;
import com.web.board.model.Board;
import com.web.board.service.AnswerBoardService;

@CrossOrigin(origins = "http://3.39.62.224:3000")
@RestController
@RequestMapping("/api")
public class AnswerBoardController {
	
	@Autowired
	private AnswerBoardService answerboardService;
	
	// get all board 
	@GetMapping("/answerboard")
	public List<AnswerBoard> getAllBoards() {
		return answerboardService.getAllAnswerBoard();
	}
	
	// create board
	@PostMapping("/answerboard")
	public AnswerBoard createBoard(@RequestBody AnswerBoard answerboard) {
		return answerboardService.createAnswerBoard(answerboard);
	}

	// get board
	@GetMapping("/answerboard/{no}")
	public ResponseEntity<AnswerBoard> getAnswerBoardByNo(
			@PathVariable Integer no) {
		
		
		return answerboardService.getAnswerBoard(no);
	}
	
	// update board
	@PutMapping("/answerboard/{noanswerboard}")
	public ResponseEntity<AnswerBoard> updateAnswerBoardByNo(
			@PathVariable Integer noanswerboard, @RequestBody AnswerBoard answerboard){
		
		
		return answerboardService.updateAnswerBoard(noanswerboard, answerboard);
	}
	
	// delete board
	@DeleteMapping("/board/{noanswerboard}")
	public ResponseEntity<Map<String, Boolean>> deleteAnswerBoardByNo(
			@PathVariable Integer noanswerboard) {
		
		return answerboardService.deleteAnswerBoard(noanswerboard);
	}
}
