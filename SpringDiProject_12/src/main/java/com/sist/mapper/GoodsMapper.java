package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.dao.*;
public interface GoodsMapper {
	
	public List<GoodsVO> goodsFindData(Map map);
	
}
