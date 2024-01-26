package com.sist.dao;

import org.springframework.stereotype.Repository;

@Repository
public class FoodDAO implements OracleDB{

	@Override
	public void display() {
		System.out.println("FoodDAO:display() Call");
	}
	
}
