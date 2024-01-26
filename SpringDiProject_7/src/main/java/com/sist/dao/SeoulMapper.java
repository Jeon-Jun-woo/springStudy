package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface SeoulMapper {
	@Select("SELECT no,title "
			+"FROM seoul_nature "
			+"ORDER BY no ASC")
	public List<SeoulVO> natureListData();
	
	@Select("SELECT no,title,address,msg "
			+"FROM seoul_nature "
			+"WHERE no=#{no}")
	public SeoulVO natureDetailData(int no);
	
	
	@Select("SELECT no,title,address,msg "
			+"FROM seoul_nature "
			+"WHERE title LIKE '%'||#{title}||'%'")
	public List<SeoulVO> natureFindData(String title);
	
	
	/*
	 *  public SeoulVO natureDetailData(int no)
	 *  {
	 *  	SeoulVO vo=new SeoulVO();
	 *  	try
	 *		{
	 *			getConnection();
	 *			String sql="SELECT ~"
	 *						+WHERE no=?"
	 *			ps=conn.preparedStatement(sql);
	 *			ps.setInt(1,no);
	 *			ResultSet rs=ps.executeQuery();
	 *			rs.next();
	 *			vo.setNo(rs.getInt(1));
	 *			vo.setTitle(rs.getString(2));
	 *			vo.setMsg(rs.getString(3));
	 *			vo.SETAddress(rs.getString(4));
	 *			rs.close();
	 *		}catch(Exception ex)
	 * 		{
	 * 			ex.printStackTrace();
	 * 		}
	 * 		finally
	 * 		{
	 * 			disConnection()
	 * 		}
	 *
	 *  	return vo;
	 *  }
	 * 
	 */
}
