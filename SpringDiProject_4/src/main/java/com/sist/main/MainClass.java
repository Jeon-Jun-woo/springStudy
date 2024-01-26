package com.sist.main;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=
				new ClassPathXmlApplicationContext("application.xml");
		EmpDAO dao=(EmpDAO)app.getBean("dao");
		List<EmpVO> list=dao.empListData();
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEmpno()+" "
					+vo.getEname()+" "
					+vo.getJob()+" "
					+vo.getHiredate()+" "
					+vo.getSal());
		}
		System.out.println("=================================");
		Scanner scan=new Scanner(System.in);
		System.out.println("사번 입력:");
		int empno=scan.nextInt();
		EmpVO vo=dao.empDetailData(empno);
		
		System.out.println(vo.getEmpno()+" "
				+vo.getEname()+" "
				+vo.getJob()+" "
				+vo.getHiredate()+" "
				+vo.getSal()); 
		
		/*DeptDAO dao=(DeptDAO)app.getBean("dao2");
		List<DeptVO> list=dao.deptListData();
		for(DeptVO vo:list)
		{
			System.out.println(vo.getDeptno()+" "
							+vo.getDname()+" "
							+vo.getLoc());
		} */
		
		
		
	}
	

}
