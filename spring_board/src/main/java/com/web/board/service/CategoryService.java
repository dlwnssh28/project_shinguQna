package com.web.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.board.entity.Board;
import com.web.board.entity.Category;
import com.web.board.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	// get boards data
		public List<Category> getAllCategory() {
			return categoryRepository.findAll();
		}
		
}
