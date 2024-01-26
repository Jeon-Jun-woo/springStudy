package com.sist.dao;
/*
 * NO                                        NOT NULL NUMBER
 TITLE                                     NOT NULL VARCHAR2(200)
 POSTER                                    NOT NULL VARCHAR2(500)
 MSG                                       NOT NULL VARCHAR2(4000)
 ADDRESS                                   NOT NULL VARCHAR2(300)
 HIT                                                NUMBER
 * 
 * 
 */
public class SeoulVO {
	private int no;
	private String title,msg,address;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
