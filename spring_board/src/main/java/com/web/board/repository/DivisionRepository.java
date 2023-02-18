package com.web.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.board.entity.Category;
import com.web.board.entity.Division;

public interface DivisionRepository extends JpaRepository<Division, Integer> {

}
