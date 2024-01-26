package com.sist.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import com.sist.dao.*;
@Component
/*
 * 	@Component
 * 		=>사용 위치 ==> {TYPE}클래스에만 적용
 * 	
 * @Autowired
 * Target(value={CONSTRUCTOR, METHOD, PARAMETER, FIELD, ANNOTATION_TYPE})
 * 				  생성자		, 메소드 , 매개변수 ,  멤버변수 , 어노테이션
 * class A
 * {
 * 		@ 필드
 * 		B b
 * 
 * 		@ 생성자
 * 		public A(){}
 * 
 * 		@메소드
 * 		public void display(){}
 * 
 * 		
 * 		public A( @매개변수 B b){}
 * }
 * 
 */
public class MainClass {
	//@Autowired + @Qualifier = @Resource(1.8)
	
	@Autowired
	@Qualifier("memberDAO") //에러나서  특정객체를 선택할때 
	private OracleDB ob; //자동대입 // 오토와이어드의 단점 : 인터페이스로 접근했을때 같은내용이잇으면 찾질못함
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		MainClass mc=(MainClass)app.getBean("mainClass");
		mc.ob.display();
	}

}
