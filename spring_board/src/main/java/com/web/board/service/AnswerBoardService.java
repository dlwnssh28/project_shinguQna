package com.web.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.web.board.exception.ResourceNotFoundException;
import com.web.board.model.AnswerBoard;
import com.web.board.repository.AnswerBoardRepository;

@Service
public class AnswerBoardService {
	@Autowired
	private AnswerBoardRepository answerboardRepository;
	
	
	// get boards data
	public List<AnswerBoard> getAllAnswerBoard() {
		return answerboardRepository.findAll();
	}
	
	// create board
	public AnswerBoard createAnswerBoard(AnswerBoard answerboard) {
		return answerboardRepository.save(answerboard);
	}
	
	// get board one by id
	public ResponseEntity<AnswerBoard> getAnswerBoard(Integer no) {
		AnswerBoard answerboard = answerboardRepository.findById(no)
				.orElseThrow(() -> new ResourceNotFoundException("Not exist AnswerBoard Data by no : ["+no+"]"));
		
		
		
		return ResponseEntity.ok(answerboard);
	}
	
	// update board 
	public ResponseEntity<AnswerBoard> updateAnswerBoard(
			Integer noanswerboard, AnswerBoard updatedAnswerBoard) {
		AnswerBoard answerboard = answerboardRepository.findById(noanswerboard)
				.orElseThrow(() -> new ResourceNotFoundException("Not exist Board Data by no : ["+noanswerboard+"]"));
		answerboard.setAnswercontents(updatedAnswerBoard.getAnswercontents());
		answerboard.setNo(updatedAnswerBoard.getNo());
		answerboard.setStudentid(updatedAnswerBoard.getStudentid());
		
		AnswerBoard endUpdatedBoard = answerboardRepository.save(answerboard);
		return ResponseEntity.ok(endUpdatedBoard);
	}
	
	// delete board
	public ResponseEntity<Map<String, Boolean>> deleteAnswerBoard(
			Integer noanswerboard) {
		AnswerBoard answerboard = answerboardRepository.findById(noanswerboard )
				.orElseThrow(() -> new ResourceNotFoundException("Not exist AnswerBoard Data by no : ["+noanswerboard+"]"));
		
		answerboardRepository.delete(answerboard);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted AnswerBoard Data by id : ["+noanswerboard+"]", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}		
		
}
