package com.web.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.web.board.model.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
		
		@Query("SELECT mb FROM Member mb WHERE mb.studentid = :studentid")
		List<Member> findByUserId(@Param("studentid") String studentid);
}
