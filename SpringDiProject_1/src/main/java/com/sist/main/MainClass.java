package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.sawon.Sawon;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 컨테이너에 등록(스프링)
		// 메모리 할당후에 멤버변수에 값을 첨부 => DI
		ApplicationContext app=
				new ClassPathXmlApplicationContext("application.xml");
		//Sawon sa1=(Sawon)app.getBean("sa1");
		Sawon sa1=app.getBean("sa1",Sawon.class);
		
		System.out.println("사번: "+sa1.getSabun());
		System.out.println("이름: "+sa1.getName());
		System.out.println("부서: "+sa1.getDept());
		System.out.println("직위: "+sa1.getJob());
		System.out.println("근무지: "+sa1.getLoc());
		
		System.out.println("=================================");
		
		Sawon sa2=app.getBean("sa2",Sawon.class);
		
		System.out.println("사번: "+sa2.getSabun());
		System.out.println("이름: "+sa2.getName());
		System.out.println("부서: "+sa2.getDept());
		System.out.println("직위: "+sa2.getJob());
		System.out.println("근무지: "+sa2.getLoc());
		
	}

}
