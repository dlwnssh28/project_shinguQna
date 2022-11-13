package com.web.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.board.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {

}
