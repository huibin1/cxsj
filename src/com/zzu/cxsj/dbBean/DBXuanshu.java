package com.zzu.cxsj.dbBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_xuanshu")
public class DBXuanshu {
	@Id
	public int xuanshuid;
	@Column
	public String teacherid;
	@Column
	public String courseid;
	@Column
	public String bookisbns;
	public int getXuanshuid() {
		return xuanshuid;
	}
	public void setXuanshuid(int xuanshuid) {
		this.xuanshuid = xuanshuid;
	}

	
	public String getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getBookisbns() {
		return bookisbns;
	}
	public void setBookisbns(String bookisbns) {
		this.bookisbns = bookisbns;
	}
	
	
}
