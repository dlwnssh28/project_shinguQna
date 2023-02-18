package com.web.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.board.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {

}
