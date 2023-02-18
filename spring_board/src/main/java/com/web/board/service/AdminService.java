package com.web.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.board.entity.Admin;
import com.web.board.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;
	
	
	// get boards data
		public List<Admin> getAllAdmin() {
			return adminRepository.findAll();
		}
		
}
