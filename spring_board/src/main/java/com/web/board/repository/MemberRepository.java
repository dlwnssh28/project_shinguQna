package com.web.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.web.board.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
		
		@Query("SELECT mb FROM Member mb WHERE mb.studentid = :studentid")
		List<Member> findByUserId(@Param("studentid") String studentid);
		
		@Query("SELECT mb FROM Member mb WHERE mb.approve = 0")
		List<Member> findApprove();
}
