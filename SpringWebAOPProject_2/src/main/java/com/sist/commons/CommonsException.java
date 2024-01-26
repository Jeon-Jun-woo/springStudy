package com.sist.commons;

import org.springframework.web.bind.annotation.ControllerAdvice;
/*
 * 	AOP : 공통 모듈 ( 공토으로 사용되는 소스를  모아서 관리)
 * 		  유지 보수 , 재사용
 * 			=> OOP에서 불가능한 것을 추가해서 보완
 * 			   ===
 * 				 자동 호출(Callback) => 불가능
 * 			=> Callback => 원하는 위치를 지정하면 호출이 가능
 * 						   -----====
 * 							1.메소드 지정 ( 지정된 메소드 => Target)
 * 							2. 메소드의 위치(JoinPoint) : @들이전부 ㅈ인포인드
 * 								public void display()
 * 								{
 * 									@before
 * 									=> 설정된 함수 호출
 * 									try
 * 									 => 로그 / 트랜잭션
 * 									{================= @Around
 * 										핵심
 * 									 =================@Around
 * 									}catch(Exceptione e)
 * 									{
 *  									@AfterThrowing
 *  									=>ContraollerAdvice
 * 									}
 * 									finally
 * 									{
 * 										@After
 * 									}
 * 									return=>	@AfterReturning
 * 								}
 * 								PointCut +JoinPoint => Advice
 * 								Advice가 여러개 => 공통모듈(Aspect)
 *    => PointCut :  어떤 메소드에서 호출할거냐
 *    => JoinPoint : 메소드 호출위치 
 *    => Weaving : 묶어준다 (조립)
 *    => Target : 대상 메소드
 *    => Proxy :  조립된 메소드(대리자)
 *    => Advice : 공통 모듈단위
 *    => Aspect : 공통 모듈
 *    
 *    public void aaa(){}
 *    public void bbb(){}
 *    public void ccc(){}
 *    
 *    class A
 *    {
 *    	public void list()
 *    	{
 *    		  ==========
 *    		select관련 소스
 *    		  ==========
 *    		disConnection()
 *    		success()
 *    	}
 *    	public void insert()
 *    	{
 *    		  ===========
 *    			insert관련 소스
 *    		  ============
 *    		disConnection()
 *    		success()
 *    	}
 *    	public void update()
 *    	{
 *    		============
 *    		update관련 소스
 *    		=============
 *    		disConnection()
 *    		success()
 *    	}
 *    }
 *    
 *    
 * 
 */
@ControllerAdvice //예외처리
public class CommonsException {

}
