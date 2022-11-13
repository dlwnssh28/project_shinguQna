package com.web.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.board.model.Division;
import com.web.board.repository.DivisionRepository;

@Service
public class DivisionService {
	@Autowired
	private DivisionRepository divisionRepository;
	
	
	// get boards data
		public List<Division> getAllDivision() {
			return divisionRepository.findAll();
		}
		
}
