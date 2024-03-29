package com.web.board.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "answerboard")
@DynamicInsert  
@DynamicUpdate 
public class AnswerBoard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer noanswerboard;

	@Column(name = "no")
	private Integer no;
	
	@Column(name = "studentid")
	private Integer studentid;
	
	@Column(name = "answercontents")
	private String answercontents;

	public Integer getNoanswerboard() {
		return noanswerboard;
	}

	public void setNoanswerboard(Integer noanswerboard) {
		this.noanswerboard = noanswerboard;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public Integer getStudentid() {
		return studentid;
	}

	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}

	public String getAnswercontents() {
		return answercontents;
	}

	public void setAnswercontents(String answercontents) {
		this.answercontents = answercontents;
	}
	
	

	
}
