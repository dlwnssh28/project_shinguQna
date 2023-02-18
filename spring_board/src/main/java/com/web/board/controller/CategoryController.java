package com.web.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.board.entity.Category;
import com.web.board.service.CategoryService;

@CrossOrigin(origins = "http://3.39.62.224:3000")
@RestController
@RequestMapping("/api")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	// get all board 
	@GetMapping("/category")
	public List<Category> getAllBoards() {
		return categoryService.getAllCategory();
	}

}
