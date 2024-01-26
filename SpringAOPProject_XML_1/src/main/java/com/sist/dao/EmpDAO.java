package com.sist.dao;
import java.util.*;
import java.sql.*;
public class EmpDAO {
	private Connection conn;
	private PreparedStatement ps;
	private MyDataSource ds;

	public EmpDAO(MyDataSource ds)
	{
		this.ds=ds;
		try
		{
			Class.forName(ds.getDriver());
		}catch(Exception ex) {}
	}
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(ds.getUrl(),
					ds.getUsername(),ds.getPassword());
		}catch(Exception ex) {}
	}
	public void disConnection()
	{
		try
		{
			if(ps!=null)
				ps.close();
			if(conn!=null)
				conn.close();
		}catch(Exception ex) {}
	}
	public List<EmpVO> empListData()
	{
		List<EmpVO> list=new ArrayList<EmpVO>();
		//before => getConnection
		try
		{
			//Around
			String sql="SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD'),sal "
					+"FROM emp";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				EmpVO vo=new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setDbday(rs.getString(4));
				vo.setSal(rs.getInt(5));
				list.add(vo);
			}
			rs.close();
			//Around
		}catch(Exception ex)
		{
			//After-Throwing
			ex.printStackTrace();
		}
		finally
		{
			//after => disConnection
		}
		return list;//=> After-Returning
	}
}
