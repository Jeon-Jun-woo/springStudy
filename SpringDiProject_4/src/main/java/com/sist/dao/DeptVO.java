package com.sist.dao;
/*
 * 	Spring
 * 		=XML ****
 * 		=Annotation
 * 		=XML+Annotation => 핵심
 *  MyBatis
 *  	= XML ****
 *  	= Annotation
 *  	= XML + Annotation => 핵심
 *  ================================
 *  
 *  
 */
public class DeptVO {
	private int deptno;
	private String dname,loc;
	
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	
}