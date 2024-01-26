package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.dao.*;
@RestController //메모리할당하는 어노테이션
public class FoodRestController {  //데이터만 넘기는용도
	@Autowired
	private FoodDAO dao;
	
	@RequestMapping(value="food/find_vue.do",produces="text/plain;charset=UTF-8")
	public String find_vue(String page,String fd)
	{
		if(page=="")
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		Map map =new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("address", fd);
		List<FoodVO> list=dao.foodFindData(map);
		JSONArray arr=new JSONArray();
		for(FoodVO vo:list)
		{
			JSONObject obj=new JSONObject();
			obj.put("fno", vo.getFno());
			obj.put("name", vo.getName());
			obj.put("poster", vo.getPoster());
			arr.add(obj); //자바스크립트가 인식하는파일로 변경  배열형식
		}
		
		return arr.toJSONString();
	}
}
