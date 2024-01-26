package com.sist.mapper;
import java.util.*;
import com.sist.dao.*;
public interface FoodMapper {
	/*
	 * 	namespace="com.sist.mapper.FoodMapper" <= xml 어노테이션 매칭할라믄 꼭
	 * <select id="foodFindData" resultType="FoodVO" parameterType="hashmap">
		   SELECT fno,name,type,address,price,content
		   FROM food_menu_house
		   WHERE ${col_name} LIKE '%'||#{ss}||'%'
		 </select>
		 동적 쿼리
	 * 
	 */
	public List<FoodVO> foodFindData(Map map);
}
