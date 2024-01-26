package com.sist.service;

import java.util.List;

import com.sist.dao.FoodVO;

public interface FoodService {
	public List<FoodVO> foodListData(String type);
	public FoodVO foodDetailData(int fno);
}
