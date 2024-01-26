package com.sist.inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/*
 * 						FrontController : 요청 받기 => 응답 확
 * 	 main.do ======= DispatcherServlet ======== HandlerMapping : Model 찾기
 * 													  |  @GetMapping/@PostMapping => 기능 수행
 * 														  ======================== Back-End
 * 						  |									프로그래머 (Model) 찾기
 * 						  |									Model(Controller,Action)
 * 															  1) VO
 * 															  2) DAO
 * 															  3) Manager
 * 															  4) Service
 * 															  5) 유지보수 ( 역할부담)
 *   				  preHandle(자동로그인 처리) 	=> @Getmapping("main.do")
 *   													|
 *   												  return "main/main";
 *   													| ---> postHandle
 *   												 ViewResolver
 *   													 | request
 *   													 | ---> afterCompletion
 *   													JSP => Front-End
 */
//<bean이용>
public class FoodIntercepter extends HandlerInterceptorAdapter{

	@Override
	// main.do 찾기 전 (모델 수행 전: 자동로그인 , id저장)
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("===== preHandle Call... =========");
		return super.preHandle(request, response, handler);
	}

	@Override
	// ViewResolver로 넘어가기 전에 사용 ( JSP에 request전송하기 전)
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("===== postHandle Call... ========");
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	// JSP로 넘어가기 전
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("===== afterCompletion =====");
		super.afterCompletion(request, response, handler, ex);
	}
	
}
