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
@Table(name = "division")
@DynamicInsert  
@DynamicUpdate 
public class Division {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer divisioncode;

	@Column(name = "divisionname")
	private String divisionname;
	
	@Column(name = "upctg")
	private Integer upctg;

	public Integer getDivisioncode() {
		return divisioncode;
	}

	public void setDivisioncode(Integer divisioncode) {
		this.divisioncode = divisioncode;
	}

	public String getDivisionname() {
		return divisionname;
	}

	public void setDivisionname(String divisionname) {
		this.divisionname = divisionname;
	}

	public Integer getUpctg() {
		return upctg;
	}

	public void setUpctg(Integer upctg) {
		this.upctg = upctg;
	}
	
	
}
