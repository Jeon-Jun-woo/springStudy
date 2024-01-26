package com.sist.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.sist.dao.*;
import com.sist.vo.FoodVO;
// DispatcherServlet을 통해서 데이터를 매개변수를 받을 수 있는 클래스
// @Controller , @RestController = >Model 에서만 가능
@Aspect //공통 모듈
@Component
public class FoodAspect {
	@Autowired
	private FoodDAO dao;
	// finally => 무조건 전송
	@After("execution(* com.sist.web.MainController.main_main(..))")
	public void cookieSend()
	{
		HttpServletRequest request=
				((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		//========================================================= PageContext 현재 사용중인 리퀘스트 얻기
		Cookie[] cookies=request.getCookies(); //리퀘스트가 잇어야 쿠키 사용이 가능
		List<FoodVO> cList=new ArrayList<FoodVO>();
		if(cookies!=null)
		{
			for(int i=cookies.length-1;i>=0;i--) //뒤에서부터 최신꺼 가져오기
			{
				 if(cookies[i].getName().startsWith("food_")) //food로시작하는 키이름 가져오기
				 {
					 String fno=cookies[i].getValue();
					 FoodVO vo=dao.foodCookieData(Integer.parseInt(fno));
					 cList.add(vo);
				 }
			}
		}
		request.setAttribute("count", cList.size());
		request.setAttribute("cList", cList);
	}
	
}
