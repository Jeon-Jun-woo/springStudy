package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
/*
 *   OOP => 반복 소스가 있는 경우
 *   		=> 한개의 클래스 안에서 => 메소드
 *   		=> 여러개의 클래스 적용 => 클래스
 *   		=> 자동 호출(AOP)
 *   AOP => OOP를 보완한 패턴
 *   
 * 
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		MyDAO dao=(MyDAO)app.getBean("dao");
		dao.select();
		System.out.println("===================");
		dao.insert();
		System.out.println("===================");
		dao.update();
		System.out.println("===================");
		dao.delete();
	}

}
