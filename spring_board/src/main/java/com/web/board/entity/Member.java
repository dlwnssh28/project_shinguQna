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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "member")
@DynamicInsert  
@DynamicUpdate 
public class Member {
	
	@Id
	private String studentid;

	@Column(name = "username")
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "divisioncode")
	private Integer divisioncode; 
	
	@Column(name = "darkmode")
	private boolean darkmode;
	
	@Column(name = "approve")
	private boolean approve;

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getDivisioncode() {
		return divisioncode;
	}

	public void setDivisioncode(Integer divisioncode) {
		this.divisioncode = divisioncode;
	}
	
	public boolean isDarkmode() {
		return darkmode;
	}

	public void setDarkmode(boolean darkmode) {
		this.darkmode = darkmode;
	}
	
	public boolean isApprove() {
		return approve;
	}

	public void setApprove(boolean approve) {
		this.approve = approve;
	}

	@Override
	public String toString() {
		return "Member [studentid =" + studentid  + ", username=" + username + ", password=" + password + ", divisioncode=" + divisioncode + ", darkmode=" + darkmode+ ", approve=" + approve + "]";
	}
}
