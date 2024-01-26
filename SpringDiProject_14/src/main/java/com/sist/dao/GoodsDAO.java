package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;

@Repository("gDao")
public class GoodsDAO {
	@Autowired
	private GoodsMapper mapper;
	
	public List<GoodsVO> goodsListData(Map map)
	{
		return mapper.goodsListData(map);
	}
	
	public GoodsVO goodsDetalData(Map map)
	{
		return mapper.goodsDetalData(map);
	}
}
