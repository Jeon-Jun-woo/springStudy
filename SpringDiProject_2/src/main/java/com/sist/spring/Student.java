package com.sist.spring;

public class Student {
	private int hakbun;
	private String name;
	private int kor,eng,math;
	public int getHakbun() {
		return hakbun;
	}
	public void setHakbun(int hakbun) {
		this.hakbun = hakbun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	// 생성시/소멸시에 자동 호출 => method DI
	public void init()
	{
		System.out.println("객체 생성");
	}
	public void destroy()
	{
		System.out.println("객체 소멸");
	}
	
}
