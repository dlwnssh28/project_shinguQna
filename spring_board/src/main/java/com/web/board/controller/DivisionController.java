package com.web.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.board.model.Category;
import com.web.board.model.Division;
import com.web.board.service.CategoryService;
import com.web.board.service.DivisionService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class DivisionController {
	
	@Autowired
	private DivisionService divisionService;
	
	// get all board 
	@GetMapping("/division")
	public List<Division> getAllBoards() {
		return divisionService.getAllDivision();
	}

}
