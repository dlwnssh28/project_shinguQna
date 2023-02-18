package com.web.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.board.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
