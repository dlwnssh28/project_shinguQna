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
	
	@Column(name = "divisioncode")
	private String divisioncode;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "contents")
	private String contents;
	
	@Column(name = "addboard")
	private boolean addboard;
	
	@Column(name = "studentid")
	private Integer studentid;
	
	@Column(name = "createdtime")
	private Date createdtime;
	
	@Column(name = "counts")
	private Integer counts;

	
	public Board() {
		super();
	}
	
	

	public Board(Integer no, String divisioncode, String category, String title, String contents,
			Integer studentid, Date createdtime, Integer counts) {
		super();
		this.no = no;
		this.divisioncode = divisioncode;
		this.category = category;
		this.title = title;
		this.contents = contents;
		this.studentid = studentid;
		this.createdtime = createdtime;
		this.counts = counts;
	}

	
	// ---Getter/Setter ---

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getDivisioncode() {
		return divisioncode;
	}

	public void setDivisioncode(String divisioncode) {
		this.divisioncode = divisioncode;
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
	
	public boolean isAddboard() {
		return addboard;
	}

	public void setAddboard(boolean addboard) {
		this.addboard = addboard;
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

	public Integer getCounts() {
		return counts;
	}

	public void setCounts(Integer counts) {
		this.counts = counts;
	}

	
}