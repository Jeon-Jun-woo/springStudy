package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class MemberController {
	@Autowired
	private MemberDAO dao;
	
	@GetMapping("member/login.do")
	public String member_login()
	{
		return "member/login";
	}
	@PostMapping("member/login_ok.do")
	public String member_login_ok(String id,String pwd,Model model,HttpSession session)//session은 매개변수로
	{
		MemberVO svo=new MemberVO();
		svo.setId(id);
		svo.setPwd(pwd);
		MemberVO vo=dao.memberLogin(svo);
		if(vo.getMsg().equals("OK"))
		{
			session.setAttribute("id", vo.getId());
			session.setAttribute("name", vo.getName());
		}
		model.addAttribute("msg",vo.getMsg());
		
		return "member/login_ok";
	}
	// => 다른 경우 => 405
	/*
	 *  1. 500 => 자바 소스 에러
	 *  2. 404 => 파일이 없는 경우
	 *  3. 405 => GET/POST
	 *  4. 400 => Bad request => 매개변수의 데이터형이 다른 경우
	 *  5. 412 => 한글변환 코드가 틀린 경우
	 *  		  UTf-8 => UFT-8  
	 * 
	 */
	@PostMapping("member/logout.do")
	public String member_logout(HttpSession session)
	{
		session.invalidate(); //세션 내용 제거
		return "redirect:../main/main.do";
		
	}
}
