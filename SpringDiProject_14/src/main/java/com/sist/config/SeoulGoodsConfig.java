package com.sist.config;
import java.util.*;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
@Configuration
//<context:component-scan base-package="com.sist.*"/>
@ComponentScan(basePackages = "com.sist.*")
//<mybatis-spring:scan base-package="com.sist.mapper" 
@MapperScan(basePackages = "com.sist.mapper")
public class SeoulGoodsConfig {
	/*
	 * <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
		p:driverClassName="oracle.jdbc.driver.OracleDriver"
		p:url="jdbc:oracle:thin:@localhost:1521:XE"
		p:username="hr"
		p:password="happy"
		p:maxActive="10"
		p:maxIdle="10"
		p:maxWait="-1" 
		/>
	 * 
	 */
	@Bean("ds")
	public BasicDataSource dataSource()
	{
		BasicDataSource ds=
				new BasicDataSource();
		// setter
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		ds.setMaxActive(10);
		ds.setMaxIdle(10);
		ds.setMaxWait(-1);
		return ds;
	}
	
	/*
	 * <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
		p:dataSource-ref="ds"
		/>
	 * 
	 */
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception
	{
		SqlSessionFactoryBean ssf=
				new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());
		return ssf.getObject();
	}
}













