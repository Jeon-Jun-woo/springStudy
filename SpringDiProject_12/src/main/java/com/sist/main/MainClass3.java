package com.sist.main;
/*
 * 	@Autowired : 반드시 스프링에서 메모리 할당을 해야 자동 주입이 가능  (메모리할당된 클래스에서만~)
 *    
 *   class A
 *   {
 *      @Autowired
 *   	B b;  ==> null  => 어노테이션이 있는지없는지 확인
 *   }
 *   
 *   
 *   @Component  <== 클래스 등록된거만)
 *   class B
 *   {
 *     @Autowired
 *     A a;   ==> 주소
 *   }
 */
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=
				new ClassPathXmlApplicationContext("application-*.xml");
		FoodDAO fDao=(FoodDAO)app.getBean("fDao");
		Scanner scan=new Scanner(System.in);
		
		System.out.print("1.업체명,2.주소,3.음식종류 선택:");
		
		int col=scan.nextInt();
		String fd="";
		String[] temp= {"","name","address","type"};
		fd=temp[col];
		System.out.print("검색어 입력:");
		String ss=scan.next();
		Map map=new HashMap();
		map.put("col_name", fd);
		map.put("ss", ss);
		List<FoodVO> list=fDao.foodFindData(map);
		
		for(FoodVO vo:list)
		{
			System.out.println(vo.getFno()+" "
							+vo.getName()+" "
							+vo.getAddress()+" "
							+vo.getType());
		}
	}

}
