package com.sist.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.DataBoardDAO;
import com.sist.dao.DataBoardVO;

@Controller
public class MainController {
	@RequestMapping("main/main.do")
	public String main_main(String page,
			Model model)
	{
		
		   if(page==null)
			   page="1";
		   int curpage=Integer.parseInt(page);
		   int rowSize=10;
		   int start=(curpage*rowSize)-(rowSize-1);
		   int end=curpage*rowSize;
		   
		   Map map=new HashMap();
		   map.put("start", start);
		   map.put("end", end);
		   
		   List<DataBoardVO> list=DataBoardDAO.databoardListData(map);
		   
		   int count=DataBoardDAO.databoardRowCount();// 30 + 2
		   int totalpage=(int)(Math.ceil(count/10.0));
		   count=count-((curpage*rowSize)-rowSize);// 20
		   
		   model.addAttribute("curpage", curpage);
		   model.addAttribute("totalpage", totalpage);
		   model.addAttribute("list", list);
		   model.addAttribute("count", count);
		   
		   
		return "main/main";
	}
	@RequestMapping("main/list.do")
	public String main_list(HttpServletRequest request,
			HttpServletResponse response)
	{
		return "redirect:../main/main.do";
	}
}
