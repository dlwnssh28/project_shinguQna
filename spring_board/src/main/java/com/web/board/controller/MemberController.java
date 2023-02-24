package com.web.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.board.entity.AnswerBoard;
import com.web.board.entity.Member;
import com.web.board.service.MemberService;

@CrossOrigin(origins = "http://3.39.62.224:3000")
@RestController
@RequestMapping("/api")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("/member")
	public Member createMember(@RequestBody Member member) {
		System.out.println("@PostMapping(\"/member\")");
		System.out.println(member.toString());
		
		return memberService.createMember(member);
	}
	
	@GetMapping("/member/{studentid}")
	public ResponseEntity<Member> getMemberStudentid(
			@PathVariable String studentid) {
		return memberService.getMember(studentid);
	}
	
	@GetMapping("/member/approve")
	public List<Member> getMemberApprovement() {
		return memberService.getMemberApprove();
	}
	
	@GetMapping("/member")
	public ResponseEntity<List<Member>> getMemberNo(
			@RequestParam String studentid) {
		return memberService.getMemberFromId(studentid);
	}
	
	// update board
	@PutMapping("/member/{no}")
	public ResponseEntity<Member> updateMemberByNo(
			@PathVariable String studentid, @RequestBody Member member){
		
		
		return memberService.updateMember(studentid, member);
		
	}
}
