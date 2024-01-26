package com.sist.main;


import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=
				new ClassPathXmlApplicationContext("application-*.xml");
		GoodsDAO dao=(GoodsDAO)app.getBean("gDao");
		Scanner scan=new Scanner(System.in);
		
		String s="";
		System.out.print("검색어 입력:");
		s=scan.next();
		List<GoodsVO> list=dao.goodsFindData(null);
	}

}
