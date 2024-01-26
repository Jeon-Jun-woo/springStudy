package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.StudentDAO;
import com.sist.dao.StudentVO;

import java.util.*;
import javassist.tools.rmi.Sample;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//메모리 할당 요청
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		StudentDAO dao=(StudentDAO)app.getBean("dao");
		Scanner scan=new Scanner(System.in);
		while(true)
		{
			System.out.println("====== 메뉴 =====");
			System.out.println("1.목록");
			System.out.println("2.상세보기");
			System.out.println("3.추가");
			System.out.println("4.수정");
			System.out.println("5.삭제");
			System.out.println("6.종료");
			System.out.println("================");
			System.out.println("메뉴 선택:");
			int menu=scan.nextInt();
			if(menu<1 || menu>6)
			{
				System.out.println("없는 메뉴입니다");
				continue;
			}
			
			if(menu==6)
			{
				System.out.println("프로그램 종료");
				break;
			}
			else if(menu==1)
			{
				List<StudentVO> list=dao.studentListData();
				for(StudentVO vo:list)
				{
					System.out.println(vo.getHakbun()+" "
							+vo.getName());
				}
			}
			else if(menu==2)
			{
				System.out.println("학번 입력:");
				int hakbun=scan.nextInt();
				StudentVO vo=dao.studentDetailData(hakbun);
				System.out.println("학번:"+vo.getHakbun());
				System.out.println("이름:"+vo.getName());
				System.out.println("국어:"+vo.getKor());
				System.out.println("영어:"+vo.getEng());
				System.out.println("수학:"+vo.getMath());
			}
			else if(menu==3)
			{
				System.out.println("이름 입력:");
				String name=scan.next();
				System.out.println("국어 입력:");
				int kor=scan.nextInt();
				System.out.println("영어 입력:");
				int eng=scan.nextInt();
				System.out.println("수학 입력:");
				int math=scan.nextInt();
				
				StudentVO vo=new StudentVO();
				vo.setName(name);
				vo.setKor(kor);
				vo.setEng(eng);
				vo.setMath(math);
				
				dao.studentInsert(vo);
				System.out.println("저장 완료!!");
			}
			else if(menu==4)
			{
				System.out.println("이름 입력:");
				String name=scan.next();
				System.out.println("국어 입력:");
				int kor=scan.nextInt();
				System.out.println("영어 입력:");
				int eng=scan.nextInt();
				System.out.println("수학 입력:");
				int math=scan.nextInt();
				
				System.out.println("학번 입력:");
				int hakbun=scan.nextInt();
				StudentVO vo=new StudentVO();
				vo.setName(name);
				vo.setKor(kor);
				vo.setEng(eng);
				vo.setMath(math);
				vo.setHakbun(hakbun);
				
				dao.studentUpdate(vo);
				System.out.println("수정 완료!!");
			}
			else if(menu==5)
			{
				System.out.println("학번 입력:");
				int hakbun=scan.nextInt();
				
				dao.studentDelete(hakbun);
				System.out.println("삭제 완료!!");
			}
		}
	}

}
