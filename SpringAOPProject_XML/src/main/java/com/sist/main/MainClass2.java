package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.MyDAO2;

public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyDAO2 dao=new MyDAO2();
		dao.select(); // this.conn-null
		dao.insert();
		dao.update();
		dao.delete();
		System.out.println("======== 적용후 =========");
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app2.xml");
		MyDAO2 dao2= (MyDAO2)app.getBean("dao");
		dao2.select();
		dao2.insert();
		dao2.update();
		dao2.delete();
	}

}
