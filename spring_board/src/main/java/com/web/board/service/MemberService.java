package com.web.board.service;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.web.board.exception.ResourceNotFoundException;
import com.web.board.exception.SystemMaintenanceException;
import com.web.board.exception.ValidationCheckException;
import com.web.board.model.Member;
import com.web.board.repository.MemberRepository;
import com.web.board.util.EncryptUtil;
import com.web.board.util.ValidationUtil;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	
	ValidationUtil vUtil = ValidationUtil.getInstance();
	EncryptUtil eUtil = EncryptUtil.getInstance();

	/**
	 * 회원가입
	 * @param member
	 * @return
	 */
	public Member createMember(Member member) {
		// 1. Member 의 유효성 체크
		if (!vUtil.validationId(member.getStudentid()) ||
			!vUtil.validationPWD(member.getPassword())) {
			new ValidationCheckException();
		}
		
		member.setPassword(member.getPassword());
	
		
		// 3. DB에 등록 
		return memberRepository.save(member);
	}

	/**
	 * 회원 정보가져오기
	 * @param no
	 * @return
	 */
	public ResponseEntity<Member> getMember(Integer no) {
		Member member = memberRepository.findById(no)
				.orElseThrow(() -> new ResourceNotFoundException("Not exist Member Data by no : ["+no+"]"));

		return ResponseEntity.ok(member);
	}

	public ResponseEntity<Member> getMemberFromId(String id) {
		Member memberList = memberRepository.findByUserId(id);
		
		return ResponseEntity.ok(memberList);
	}
 	
}