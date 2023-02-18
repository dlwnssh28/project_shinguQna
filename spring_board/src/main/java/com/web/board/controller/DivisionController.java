package com.web.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.board.entity.Category;
import com.web.board.entity.Division;
import com.web.board.service.CategoryService;
import com.web.board.service.DivisionService;

@CrossOrigin(origins = "http://3.39.62.224:3000")
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
