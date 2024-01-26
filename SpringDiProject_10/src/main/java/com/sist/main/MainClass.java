package com.sist.main;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=
				new ClassPathXmlApplicationContext("application-*.xml");
		CategoryDAO cDao=(CategoryDAO)app.getBean("cDao");
		FoodDAO fDao=(FoodDAO)app.getBean("fDao");
		
		
		List<CategoryVO> cList=cDao.foodCategoryData();
		for(CategoryVO vo:cList)
		{
			System.out.println(vo.getCno()+"."+vo.getTitle());
		}
		System.out.println("================================");
		Scanner scan=new Scanner(System.in);
		System.out.println("카테고리 선택(1~30):");
		int cno=scan.nextInt();
		List<FoodVO> fList=fDao.foodCategoryListData(cno);
		CategoryVO cvo=cDao.categoryInfoData(cno);
		System.out.println("==================================");
		System.out.println(cvo.getTitle());
		System.out.println(cvo.getSubject());
		System.out.println("==================================");
		for(FoodVO vo:fList)
		{
			System.out.println(vo.getFno()+" "
					+vo.getName()+" "
					+vo.getAddress()+" "
					+vo.getPhone()+" "
					+vo.getType());
		}
		System.out.println("================================");
		System.out.println("맛집 선택:");
		int fno=scan.nextInt();
		
		FoodVO fvo=fDao.foodDetailData(fno);
		
		System.out.println("업체명:"+fvo.getName()+"("+fvo.getScore()+")");
		System.out.println("주소:"+fvo.getAddress());
		System.out.println("전화:"+fvo.getPhone());
		System.out.println("음식종류:"+fvo.getType());
		System.out.println("가격대:"+fvo.getPrice());
		System.out.println("영업시간:"+fvo.getTime());
		System.out.println("주차:"+fvo.getParking());
		System.out.println("메뉴:"+fvo.getMenu());
	}
}
