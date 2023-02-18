package com.web.board.service;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.web.board.entity.AnswerBoard;
import com.web.board.entity.Member;
import com.web.board.exception.ResourceNotFoundException;
import com.web.board.exception.SystemMaintenanceException;
import com.web.board.exception.ValidationCheckException;
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
		// 2. 패스워드의 암호화 
				try {
					member.setPassword(eUtil.encryptSHA256(member.getPassword()));
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
					new SystemMaintenanceException();
				}
		
		//member.setPassword(member.getPassword());

		member.setApprove(false);
		
		// 3. DB에 등록 
		return memberRepository.save(member);
	}

	/**
	 * 회원 정보가져오기
	 * @param studentid
	 * @param member2 
	 * @return
	 */
	public ResponseEntity<Member> getMember(String studentid) {
		Member member = memberRepository.findById(studentid)
				.orElseThrow(() -> new ResourceNotFoundException("Not exist Member Data by no : ["+studentid+"]"));
		System.out.println(member);
		return ResponseEntity.ok(member);
	}
	
	public ResponseEntity<List<Member>> getMemberFromId(String studentid) {
		
		List<Member> memberList = memberRepository.findByUserId(studentid);
		System.out.println(memberList);
		//System.out.println(member.getPassword().equals(memberList.getPassword()));
		//String pw = eUtil.encryptSHA256(memberList.getPassword());
		//System.out.println(memberList.getPassword().equals(eUtil.encryptSHA256(memberList.getPassword())));
		return ResponseEntity.ok(memberList);
	}
	
	
	/*
	public ResponseEntity<Boolean> getMemberFromId(String id) {
		List<Member> memberList = memberRepository.findByUserId(id);
		Boolean result = false;
		try {
			result = (memberList != null && memberList.size() != 0 &&!memberList.get(0).getStudentid().equals("")) ? true : false;
		} catch (Exception e) {e.printStackTrace();}
		
		return ResponseEntity.ok(result);
	}
	*/
	
	// update board 
		public ResponseEntity<Member> updateMember(
				String studentid, Member updatedMember) {
			Member member = memberRepository.findById(studentid)
					.orElseThrow(() -> new ResourceNotFoundException("Not exist Board Data by no : ["+studentid+"]"));
			member.setUsername(updatedMember.getUsername());
			member.setPassword(updatedMember.getPassword());
			member.setDarkmode(updatedMember.isDarkmode());
			member.setApprove(updatedMember.isApprove());
			//member.setDivisioncode(updatedMember.getDivisioncode());
			//member.setStudentid(updatedMember.getStudentid());
			
			Member endMember= memberRepository.save(member);
			return ResponseEntity.ok(endMember);
		}
		
		
 	
}