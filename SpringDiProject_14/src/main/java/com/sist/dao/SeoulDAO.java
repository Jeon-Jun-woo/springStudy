package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
//메모리 할당 요청
@Repository("sDao")
public class SeoulDAO {
	// 구현된 메퍼 (스프링 내부에 구현)
	@Autowired
	private SeoulMapper mapper;
	
	public List<SeoulVO> seoulListData(Map map) //$가 들어갈때는 String : x  , Map으로 해야됨
	{
		return mapper.seoulListData(map);
	}
	public SeoulVO seoulDetailData(Map map)
	{
		return mapper.seoulDetailData(map);
	}
}
