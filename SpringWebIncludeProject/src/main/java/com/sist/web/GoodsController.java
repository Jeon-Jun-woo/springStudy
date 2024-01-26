package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.*;
import com.sist.vo.*;

@Controller
public class GoodsController {
	@Autowired
	private GoodsDAO dao;
	
	@GetMapping("store/list.do")
	public String store_list(String page,Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		
		List<GoodsVO> list=dao.goodsListData(start, end);
		int totalpage=dao.goodsTotalpage();
		
		System.out.println(list);
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("list",list);
		model.addAttribute("main_jsp","../store/list.jsp");
		return "main/main";
	}
}
