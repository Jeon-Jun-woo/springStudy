package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface SeoulMapper {
	@Select("SELECT no,title "
			+"FROM seoul_shop "
			+"ORDER BY no ASC")
	public List<SeoulVO> seoulListData();
	
	@Select("SELECT no,title,address,msg "
			+"FROM seoul_shop "
			+"WHERE no=#{no}")
	public SeoulVO seoulDetailData(int no);
	
	
}
