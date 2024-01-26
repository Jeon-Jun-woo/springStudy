package com.sist.main;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.config.FoodConfig;
import com.sist.dao.*;
import com.sist.service.*;
/*
 *  스프링 => 클래스 메모리 할당 (생성) => 저장
 *  							========
 *  							스프링을 통해서 받는다
 *  							=> @AutoWired
 *  							직접 받을거냐
 * 								=> getBean("id명")
 * 	=> DI
 * 	    = 1. setter DI , 2. 생성자  DI
 * 		= XML
 * 			p:변수명 (프로펄티)
 * 			c:변수명 (생성자)
 * 		= Annotation
 * 			직접처리 
 */
public class MainClass {
	/*
	 * @Autowired private FoodService service;
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//FoodService 
		AnnotationConfigApplicationContext app=
				new AnnotationConfigApplicationContext(FoodConfig.class);
		/*
		 * ApplicationContext app= new ClassPathXmlApplicationContext("app.xml");
		 */
		FoodService service=(FoodService)app.getBean("fService");
		Scanner scan=new Scanner(System.in);
		while(true)
		{
			System.out.println("===== Menu =====");
			System.out.println("1.한식");
			System.out.println("2.양식");
			System.out.println("3.일식");
			System.out.println("4.중식");
			System.out.println("================");
			System.out.print("선택:");
			int no=scan.nextInt();
			String[] temp= {"","한식","양식","일식","중식"};
			String data=temp[no];
			List<FoodVO> list=service.foodListData(data);
			for(FoodVO vo:list)
			{
				System.out.println(vo.getFno()+"."+vo.getName());
			}
			System.out.println("상세 맛집 선택:");
			int fno=scan.nextInt();
			FoodVO vo=service.foodDetailData(fno);
			System.out.println("업체명:"+vo.getName());
			System.out.println("음식종류:"+vo.getType());
			System.out.println("주소:"+vo.getAddress());
			System.out.println("가격대:"+vo.getPrice());
			System.out.println("영업시간:"+vo.getTime());
			System.out.println(vo.getContent());
		}
	}

}
