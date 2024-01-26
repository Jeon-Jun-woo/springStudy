package com.sist.dao;

import java.util.List;

public class SeoulDAO {
	 private SeoulMapper mapper;

	public void setMapper(SeoulMapper mapper) {
		this.mapper = mapper;
	}
	 
	public List<SeoulVO> natureListData()
	{
		return mapper.natureListData();
	}
	
	public SeoulVO natureDetailData(int no)
	{
		return mapper.natureDetailData(no);
	}
	 
	
	public List<SeoulVO> natureFindData(String title)
	{
		return mapper.natureFindData(title);
	}
}
