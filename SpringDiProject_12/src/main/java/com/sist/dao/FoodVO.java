package com.sist.dao;
/*
 * FNO                                       NOT NULL NUMBER
 POSTER                                    NOT NULL VARCHAR2(1000)
 NAME                                      NOT NULL VARCHAR2(300)
 TYPE                                      NOT NULL VARCHAR2(100)
 ADDRESS                                   NOT NULL VARCHAR2(500)
 PHONE                                     NOT NULL VARCHAR2(100)
 SCORE                                              NUMBER(2,1)
 THEME                                     NOT NULL VARCHAR2(4000)
 PRICE                                              VARCHAR2(100)
 TIME                                               VARCHAR2(200)
 SEAT                                               VARCHAR2(100)
 CONTENT                                            CLOB
 LINK                                               VARCHAR2(300)
 HIT                                                NUMBER
 LIKE_COUNT                                         NUMBER
 RDAY                                               VARCHAR2(100)
 * 
 */
public class FoodVO {
	private int fno;
	private String name,type,address,price,time,content;
	
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
