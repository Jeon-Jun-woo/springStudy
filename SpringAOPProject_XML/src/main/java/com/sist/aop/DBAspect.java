package com.sist.aop;

public class DBAspect {
	public void getConnection()
	{
		System.out.println("오라클 연결...");
	}
	public void disConnection()
	{
		System.out.println("오라클 해제...");
	}
}
