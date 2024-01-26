package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
@Repository("gDao")
public class GoodsDAO {
	@Autowired
	private GoodsMapper mapper;
	
	public List<GoodsVO> goodsFindData(Map map)
	{
		return mapper.goodsFindData(map);
	}
}
