package com.zzu.cxsj.dbBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_student")
public class DBStudent {
	@Id
	private String userid;
	@Column
	private String name;
	@Column
	private String password;
	@Column
	private String yuanxi;
	@Column
	private String zhuanye;
	@Column
	private String cclass;
	@Column
	private Float yue;
	@Column
	private int orderids;
	@Column
	private String dormitory;
	@Column
	private String grade;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getYuanxi() {
		return yuanxi;
	}
	public void setYuanxi(String yuanxi) {
		this.yuanxi = yuanxi;
	}
	public String getZhuanye() {
		return zhuanye;
	}
	public void setZhuanye(String zhuanye) {
		this.zhuanye = zhuanye;
	}
	public String getCclass() {
		return cclass;
	}
	public void setCclass(String cclass) {
		this.cclass = cclass;
	}
	public Float getYue() {
		return yue;
	}
	public void setYue(Float yue) {
		this.yue = yue;
	}
	public int getOrderids() {
		return orderids;
	}
	public void setOrderids(int orderids) {
		this.orderids = orderids;
	}
	public String getDormitory() {
		return dormitory;
	}
	public void setDormitory(String dormitory) {
		this.dormitory = dormitory;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	

}
