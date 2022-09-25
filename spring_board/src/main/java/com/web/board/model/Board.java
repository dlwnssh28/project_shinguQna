package com.web.board.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "board")
@DynamicInsert  
@DynamicUpdate 
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer no;
	
	@Column(name = "division")
	private String division;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "contents")
	private String contents;
	
	@Column(name = "answercontents")
	private String answercontents;
	
	@Column(name = "answer")
	private boolean answer;
	
	@Column(name = "studentid")
	private Integer studentid;
	
	@Column(name = "createdtime")
	private Date createdtime;
	
	public Board() {
		super();
	}
	
	

	public Board(Integer no, String division, String department, String category, String title, String contents,
			String answercontents, boolean answer, Integer studentid, Date createdtime) {
		super();
		this.no = no;
		this.division = division;
		this.department = department;
		this.category = category;
		this.title = title;
		this.contents = contents;
		this.answercontents = answercontents;
		this.answer = answer;
		this.studentid = studentid;
		this.createdtime = createdtime;
	}


	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getAnswercontents() {
		return answercontents;
	}

	public void setAnswercontents(String answercontents) {
		this.answercontents = answercontents;
	}

	public boolean isAnswer() {
		return answer;
	}

	public void setAnswer(boolean answer) {
		this.answer = answer;
	}

	public Integer getStudentid() {
		return studentid;
	}

	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}

	public Date getCreatedtime() {
		return createdtime;
	}

	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}

	
	// ---Getter/Setter ---
	
	

	

}