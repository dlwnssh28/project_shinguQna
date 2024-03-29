package com.web.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.board.entity.Admin;
import com.web.board.entity.Division;
import com.web.board.service.AdminService;

@CrossOrigin(origins = "http://3.39.62.224:3000")
@RestController
@RequestMapping("/api")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	// get all board 
	@GetMapping("/admin")
	public List<Admin> getAllBoards() {
		return adminService.getAllAdmin();
	}

}
