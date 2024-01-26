package com.sist.mapper;
import java.util.*;
import com.sist.dao.*;
public interface EmpMapper {
	//<select id="empAllData" resultMap="empMap">
	// id=method명
	// resultType,resultMap = return형
	// parameterType = 매개변수
	public List<EmpVO> empAllData();
	// 
	public EmpVO empDetailData(int empno);
}
