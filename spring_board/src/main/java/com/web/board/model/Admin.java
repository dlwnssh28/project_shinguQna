package com.web.board.model;

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
@Table(name = "admin")
@DynamicInsert  
@DynamicUpdate 
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String adminid;

	@Column(name = "adminpwd")
	private String adminpwd;
	
	@Column(name = "divisioncode")
	private Integer divisioncode;

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getAdminpwd() {
		return adminpwd;
	}

	public void setAdminpwd(String adminpwd) {
		this.adminpwd = adminpwd;
	}

	public Integer getDivisioncode() {
		return divisioncode;
	}

	public void setDivisioncode(Integer divisioncode) {
		this.divisioncode = divisioncode;
	}

	
}
