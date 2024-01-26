package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * 		DI 생명주기
 * 		1. 컨테이너 생성 => ApplicationContext
 * 		2. XML/Annotation => 빈생성 (객체 생성) => 어떤 객체 생성
 * 		 	VO , MainClass => 제외
 * 		3. 주입(setter,constructor)
 *  	4. 초기화 콜백 => init-method 
 *  	5.  프로그래머가 사용
 *  	6. 소멸 => 콜백 destory-method
 *  	7. 스프링 종료
 * 
 */
public class MainClass {
	public static void main(String[] args) {
		GenericApplicationContext app=
				new GenericXmlApplicationContext("app.xml");
		Sawon sa=(Sawon)app.getBean("sa");
		sa.print();
		app.close();
	}
}
