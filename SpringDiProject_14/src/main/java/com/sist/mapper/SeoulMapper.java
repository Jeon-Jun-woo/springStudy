package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.dao.*;
public interface SeoulMapper {
	//목록
	@Select("SELECT no,title "
			+"FROM ${table_name} "
			+"ORDER BY no ASC")
	public List<SeoulVO> seoulListData(Map map);
	
	@Select("SELECT no,title,msg,address "
			+"FROM ${table_name} "
			+"WHERE no=#{no}")
	public SeoulVO seoulDetailData(Map map);
}
