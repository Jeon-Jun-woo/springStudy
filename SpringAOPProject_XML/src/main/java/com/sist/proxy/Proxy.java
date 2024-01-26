package com.sist.proxy;
// 대리자 => 대신 호출
/*
 *  AOP ==> 위빙은 메소드를 결합
 *  
 *  어떤 클래스의 어떤 메소드에 적용 => PoinCut
 *  어떤 시점 => JoinPoint
 *    => Before : try 수행전
 *    => After : finally
 *    => After-Returning: 정상 수행시에 => 웹 전송
 *    => After-Throwing : catch수행 => 웹 ( 오류 발생)
 *    => Around
 *    	 로그 / 트랜젝션
 *    	 = 로그
 *    	   => 1. 시간 , 호출메소드 => setAutoCommit(false)
 *    		  => 수행문장		
 *    	   =>2. 시간 => commit()
 *    PointCut+JoinPoint => Advice
 *    
 */
public class Proxy {
  private Sawon sawon;
  public Proxy(Sawon sa)
  {
	  this.sawon = sa; 
  }
  // 위빙 : 메소드 합쳐주는거
  public void display()
  {
	  System.out.println("Before 처리");
	  sawon.display();
	  System.out.println("After 처리");
  }
}
