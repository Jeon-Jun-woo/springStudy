package com.sist.aop;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sist.dao.*;
import java.util.*;

@Aspect
@Component //메모리 할당
/*
 *   1. 모니터링/ 로깅 / 오류검사 (처리) / 성능 파악
 *   	=>트랜젝션 , 보안 , 암호화 복호화, 데이터 읽기 => 분석
 * 	 = 공통된 기능을 재사용하는 기법
 *   = 공통적인 내용을 모아서 관리 => 유지보수
 *   = 라이브러리 ( 트랜잭션 , 보안)
 *   
 *   Spring FrameWork
 *   => DI
 *   => AOP
 *   => MVC
 *   ---------------------------------
 *   
 *   1. 어떤 클래스의 메소드에서 적용
 *   	PointCut
 *       => execution("특정위치 지정")
 *       => within("패키지명")
 *   2. 메소드 위치 => JoinPoint
 *        = Before
 *        = After : finally
 *        = AfterReturning : 정상수행 => return값을 받을 수 있다
 *        = AfterThrowing : 에러처리 
 *        = Around
 *   3. 인터셉트 : 자동 로그인 , ID 저장 ...
 *      public void display()
 *      {
 *      	@Before
 *      	try
 *      	{
 *      		=========== setAutoCommit(false)
 *       		 소스
 *      		=========== commit()
 *      	}catch(Exception e)
 *      	{
 *      		afterThrowing() => rollback
 *      	}
 *      	finally
 *      	{
 *      		after(); => setAutoCommit(true)
 *      	}
 *      	afterReturning()
 *      	return ""
 *      }
 *      
 *      예)
 *      @Before
 *      public void before()
 *      {
 *      }
 *      @after
 *      public void after()
 *      {
 *      }
 *      @AfterReturning
 *      public void afterReturning()
 *      {
 *      }
 *      @AfterThrowing
 *      public void afterThrowing()
 *      {
 *      }
 *     
 */
public class BoardAOP {
	@Autowired
	private BoardDAO dao;
	
	@After("execution(* com.sist.web.*Controller.*(..))") //모든 클래스에 모든 메소드에 적용
	public void after()
	{
		List<BoardVO> list = dao.boardTop5();
		// 실제 사용중인 request를 가지고 올때 사용 => Cookie
		// 컨트롤러가 올라간곳만 디스패처가 모델을 관리
		// 컨트롤러가 없으면 requset를 가져올 수가 없음
		HttpServletRequest request=
				((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).
				getRequest();
		request.setAttribute("tList", list);
		//리퀘스트 받아올때
	}
}
