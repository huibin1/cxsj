package com.zzu.cxsj.dbBean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.JSONObject;

@Entity
@Table(name = "m_book")
public class DBBook {
	@Id
	public String isbn;
	@Column
	public String bookname;
	@Column
	public String author;
	@Column
	public String edition;
	@Column
	public Float price;
	@Column	
	public String pic_path;
	@Column
	public String describe;
	@Column
	public String classifycode;
	@Column
	public String pubtime;
	@Column
	public String publisher;
	@Column
	public String commentid;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public String getPic_path() {
		return pic_path;
	}
	public void setPic_path(String pic_path) {
		this.pic_path = pic_path;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getClassifycode() {
		return classifycode;
	}
	public void setClassifycode(String classifycode) {
		this.classifycode = classifycode;
	}
	public String getPubtime() {
		return pubtime;
	}
	public void setPubtime(String pubtime) {
		this.pubtime = pubtime;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getCommentid() {
		return commentid;
	}
	public void setCommentid(String commentid) {
		this.commentid = commentid;
	}
	@Override
	public String toString() {
		return "DBBook [isbn=" + isbn + ", bookname=" + bookname + ", author=" + author + ", edition=" + edition
				+ ", price=" + price + ", pic_path=" + pic_path + ", describe=" + describe + ", classifycode="
				+ classifycode + ", pubtime=" + pubtime + ", publisher=" + publisher + ", commentid=" + commentid + "]";
	}
	
	
	

}
