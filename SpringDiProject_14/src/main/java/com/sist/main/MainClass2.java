package com.sist.main;
import java.util.*;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sist.dao.*;
import com.sist.config.*;
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext app=
				new AnnotationConfigApplicationContext(
						SeoulGoodsConfig.class);
		SeoulDAO sDao=(SeoulDAO)app.getBean("sDao");
		GoodsDAO gDao=app.getBean("gDao",GoodsDAO.class);
		String[] stable= {"","seoul_location","seoul_nature","seoul_shop"};
		String[] gtable= {"","goods_all","goods_best",
							"goods_special","goods_new"};
		Scanner scan=new Scanner(System.in);
		while(true)
		{
			System.out.println("===== Menu =====");
			System.out.println("1.여행");
			System.out.println("2.상품");
			System.out.println("3.종료");
			System.out.println("================");
			System.out.print("선택:");
			int index=scan.nextInt();
			if(index==1)
			{
				System.out.println("===== 서브메뉴 =====");
				System.out.println("1. 명소");
				System.out.println("2. 자연 & 관광");
				System.out.println("3. 쇼핑");
				System.out.println("==================");
				System.out.print("여행 선택:");
				int sno=scan.nextInt();
				String tab_name=stable[sno];
				Map map=new HashMap();
				map.put("table_name", tab_name);
				List<SeoulVO> list=sDao.seoulListData(map);
				for(SeoulVO vo:list)
				{
					System.out.println(vo.getNo()+"."+vo.getTitle());
				}
				System.out.println("=================================");
				System.out.print("상세 볼 여행 번호 선택:");
				int no=scan.nextInt();
				map.put("no", no);
				SeoulVO vo=sDao.seoulDetailData(map);
				System.out.println("여행지:"+vo.getTitle());
				System.out.println("소개:"+vo.getMsg());
				System.out.println("주소:"+vo.getAddress());
			}
			else if(index==2)
			{
				System.out.println("===== 서브메뉴 =====");
				System.out.println("1.전체 상품");
				System.out.println("2.베스트 상품");
				System.out.println("3.특가 상품");
				System.out.println("4.신상품");
				System.out.println("==================");
				System.out.print("서브 메뉴 선택:");
				int gno=scan.nextInt();
				String table_name=gtable[gno];
				Map map=new HashMap();
				map.put("table_name", table_name);
				List<GoodsVO> list = gDao.goodsListData(map);
				for(GoodsVO vo:list)
				{
					System.out.println(vo.getNo()+"."+vo.getName());
				}
				System.out.println("=======================");
				System.out.println("상세볼 상품선택:");
				int no=scan.nextInt();
				map.put("no", no);
				GoodsVO vo=gDao.goodsDetalData(map);
				System.out.println("상품명:"+vo.getName());
				System.out.println("가격:"+vo.getPrice());
				System.out.println("소개:"+vo.getSub());
				System.out.println("할인:"+vo.getDiscount()+"%");
			}
			else
			{
				System.out.println("프로그램 종료");
				break;
			}
			
		}
	}

}
