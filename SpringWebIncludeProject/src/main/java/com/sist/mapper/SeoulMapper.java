package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.sist.vo.*;
public interface SeoulMapper {
	/*
	 * CREATE OR REPLACE PROCEDURE seoulLocationData(
    pStart NUMBER,
    pEnd NUMBER,
    pResult OUT SYS_REFCURSOR
	)
	IS
	BEGIN
	    OPEN pResult FOR
	     SELECT no,title,poster,msg,address,hit,num
	     FROM (SELECT no,title,poster,msg,address,hit,rownum as num
	     FROM (SELECT no,title,poster,msg,address,hit
	     FROM seoul_location ORDER BY no ASC))
	     WHERE num BETWEEN pStart AND pEnd;
	END;
	/
	 * 
	 */
	@Select(value="{CALL seoulLocationData(#{pStart,mode=IN,javaType=java.lang.Integer},#{pEnd,mode=IN,javaType=java.lang.Integer},#{pResult,mode=OUT,jdbcType=CURSOR,resultMap=seoulMap})}") //데이터가 뭐가들어갈지 호환해줘야됨 결과값을 안주면 값을 못받음
	@Options(statementType = StatementType.CALLABLE) //CALL로바꿔야함  디폴트에서
	public List<SeoulVO> seoulListData(Map map);
	
	/*
	 * CREATE OR REPLACE PROCEDURE seoulLocationTotalPage(
    pTotal OUT NUMBER    
	)
	IS
	BEGIN
	    SELECT CEIL(COUNT(*)/12.0) INTO pTotal
	    FROM seoul_location;
	END;
	/
	 * 
	 */
	@Select(value="{CALL seoulLocationTotalPage(#{pTotal,mode=OUT,jdbcType=INTEGER})}")
	@Options(statementType = StatementType.CALLABLE)
	public Integer seoulTotalPage(Map map);
	/*
	 *  <select id="seoulLocationTotalPage" resultType="int">
		   SELECT CEIL(COUNT(*)/12.0) FROM seoul_location
		  </select>
	 * 
	 */
	public int seoulLocationTotalPage();
}
