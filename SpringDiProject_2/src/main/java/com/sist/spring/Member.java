package com.sist.spring;
import java.util.*;
public class Member {
	private int mno;
	private String name;
	private String address;
	public Member(int mno, String name, String address) {
		this.mno = mno;
		this.name = name;
		this.address = address;
	}
	 public void print()
	 {
		 System.out.println("회원번호:"+mno);
		 System.out.println("이름:"+name);
		 System.out.println("주소:"+address);
	 }
	
	
}
