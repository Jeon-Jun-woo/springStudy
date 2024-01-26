package com.sist.commons;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice  // 공통 예외처리
public class CommonsException {
	@ExceptionHandler(RuntimeException.class) //실행시 에러낫을떄
	public void runtimeExeption(RuntimeException ex)
	{
		System.out.println("======= Runtime ==============");
		ex.printStackTrace();
		System.out.println("==============================");
	}
	@ExceptionHandler(IOException.class)
	public void ioException(IOException ex)
	{
		System.out.println("=========  IOException ========");
		ex.printStackTrace();
		System.out.println("===============================");
	}
	@ExceptionHandler(SQLException.class)
	public void sqlException(SQLException ex)
	{
		System.out.println("=========  SQLException ========");
		ex.printStackTrace();
		System.out.println("===============================");
	}
}
