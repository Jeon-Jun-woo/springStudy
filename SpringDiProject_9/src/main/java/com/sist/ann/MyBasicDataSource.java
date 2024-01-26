package com.sist.ann;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Component;

@Component("ds")
// bean id="ds"

public class MyBasicDataSource extends BasicDataSource {
	/*
	 * <bean id="ds"
	  class="org.apache.commons.dbcp.BasicDataSource"
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
	public MyBasicDataSource()
	{
		setDriverClassName("oracle.jdbc.driver.OracleDriver");
		setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		setUsername("hr");
		setPassword("happy");
		setMaxActive(10);
		setMaxIdle(10);
		setMaxWait(-1);
	}
}
