package com.sist.main;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Sawon implements InitializingBean,DisposableBean,BeanNameAware{
	private int sabun;
	private String name;
	private String dept;
	
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		System.out.println("setSabun() Call...");
		this.sabun = sabun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("setName() Call...");
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		System.out.println("setDept() Call...");
		this.dept = dept;
	}
	// 프로그래머에 의해 호출 
	public void print()
	{
		System.out.println("사번:"+sabun);
		System.out.println("이름:"+name);
		System.out.println("부서:"+dept);
		
	}
	//init-method
	public void init()
	{
		System.out.println("=== 사원 정보 ===");
	}
	//destroy-method
	public void destroy()
	{
		System.out.println("=== 객체 소멸 ===");
	}
	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		System.out.println("빈 이름 설정=> Map에 저장");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("setter설정 완료");
	}
}
