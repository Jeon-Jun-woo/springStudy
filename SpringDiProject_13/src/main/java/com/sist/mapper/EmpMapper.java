package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import com.sist.dao.*;
import com.sist.dao.EmpVO;
public interface EmpMapper {
	@Select("SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,"
			+"sal,deptno "
			+"FROM emp")
	public List<EmpVO> empListData();
}
