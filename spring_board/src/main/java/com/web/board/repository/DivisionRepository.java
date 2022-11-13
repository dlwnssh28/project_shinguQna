package com.web.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.board.model.Category;
import com.web.board.model.Division;

public interface DivisionRepository extends JpaRepository<Division, Integer> {

}
