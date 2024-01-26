package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.dao.FoodVO;
public interface FoodMapper {
    //=> 카테고리별 맛집
	@Select("SELECT fno,name,address,phone,type "
			+"FROM food_house "
			+"WHERE cno=#{cno}")
	public List<FoodVO> foodCategoryListData(int cno);
	// => 맛집의 정보
	
	@Select("SELECT fno,name,address,score,phone,type,price,"
			+"parking,time,menu "
			+"FROM food_house "
			+"WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);
}
