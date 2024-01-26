package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.GoodsMapper;
import com.sist.vo.*;
@Repository
public class GoodsDAO {
	@Autowired
	private GoodsMapper mapper;
	
	public List<GoodsVO> goodsListData(int start,int end)
	{
		return mapper.goodsListData(start, end);
	}
	

	public int goodsTotalpage()
	{
		return mapper.goodsTotalpage();
	}
	
	public GoodsVO goodsDetailData(int no)
	{
		mapper.goodsHitIncrement(no);
		return mapper.goodsDetailData(no);
	}
}
