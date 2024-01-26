package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.dao.FoodVO;

/*
 *   name => N
 *   address => A
 *   type => T
 *   name+address=> NA
 *   name+type => NT
 *   address+type => AT
 *   name+ address+type => NAT 
 *   대문자 끄집어내는게 fd
 * 	 if(ss=='N')
 * 	 OR name LIKE ~
 *   else if(ss=='A')
 *   OR addresss LIKE ~
 *   else if(ss=='T')
 *   OR type LIKE ~
 */
//OR(name LIKE '%'||#{ss}||'%') OR (address LIKE '%'||#{ss}||'%') OR  
// prefixOverrides 제거 ,   prefix 추가  
public interface FoodMapper {
	//XML
	/*
	 * 	<trim prefix="(" suffix=")" prefixOverrides="("
	 * 		 접두어            접미어				
	 * 	suffixOverrides=")">
	 *  => 추가 , 제거
	 * 	name LIKE '%'||#{ss}||'%'
	 * </trim>
	 *   => name LIKE '%'||#{ss}||'%'
	 *   
	 *   
	 *   <foreach collection=\"fsArr\" item=\"fd\">
	 *   					  배열/리스트     값을 한개씩 읽기
	 *   
	 *   => for(String fd:fsArr)
	 *   
	 *   
	 *   ==> fd =='A'    "A" == 65   그래서뒤에 toString 붙이기
	 */
	@Select("<script>"
			+"SELECT fno,name,type,address "
			+"FROM food_menu_house "
			+"WHERE "
			+"<trim prefixOverrides=\"OR\">"
			+"<foreach collection=\"fsArr\" item=\"fd\">"
			+"<choose>"
			+"<when test=\"fd=='N'.toString()\">"
			+"OR name LIKE '%'||#{ss}||'%'"
			+"</when>"
			+"<when test=\"fd=='A'.toString()\">"
			+"OR address LIKE '%'||#{ss}||'%'"
			+"</when>"
			+"<when test=\"fd=='T'.toString()\">"
			+"OR type LIKE '%'||#{ss}||'%'"
			+"</when>"
			+"</choose>"
			+"</foreach>"
			+"</trim>"
			+"</script>"
			)
	public List<FoodVO> foodFindData(Map map);
	
}
