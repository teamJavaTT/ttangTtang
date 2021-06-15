package admin.outuser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import admin.outuser.model.OutUsercolumn;
import jdbc.JdbcUtil;

public class OutUserDao {
	
	// select 부분 시작
	
	public int selectCount(Connection conn) throws SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from secession");
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		
	}
	
	public List<OutUsercolumn> outuserSelect(Connection conn, int startNo, int endNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from(select row_number() over (order by sNo desc) num, A.* from secession A order by sNo desc) where num between ? and ?");
			pstmt.setInt(1, startNo);
			pstmt.setInt(2, endNo);
			rs = pstmt.executeQuery();
			List<OutUsercolumn> result = new ArrayList<>();
			while (rs.next()) {
				result.add(outuserConvert(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public OutUsercolumn outuserReadSelect(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from secession where sNo = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			OutUsercolumn outuserColumn = null;
			if (rs.next()) {
				outuserColumn = outuserConvert(rs);
			}
			return outuserColumn;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	private OutUsercolumn outuserConvert(ResultSet rs) throws SQLException {
		return new OutUsercolumn(rs.getInt("sNo"), rs.getString("userId"), rs.getString("sText"), rs.getDate("sDate"), rs.getDate("scDate"));
	}
	// select 부분 끝
	
	//업데이트
	/*
	 * public OutUsercolumn useridUpdate(Connection conn, OutUsercolumn notice)
	 * throws SQLException { PreparedStatement pstmt = null; Statement stmt = null;
	 * ResultSet rs = null; try { pstmt =
	 * conn.prepareStatement("update outuser set ftit = ?, ftext = ? where fno = ?"
	 * ); pstmt.setString(1, notice.getFtit()); pstmt.setString(2,
	 * notice.getFtext()); pstmt.setInt(3, notice.getFno()); int insertedCount =
	 * pstmt.executeUpdate();
	 * 
	 * if (insertedCount > 0) { stmt = conn.createStatement(); rs =
	 * stmt.executeQuery("select max(fno) from OutUser"); if (rs.next()) { Integer
	 * newNo = rs.getInt(1); return new OutUsercolumn(newNo, notice.getFtit(),
	 * notice.getFtext(), notice.getFdate()); } } return null; }finally {
	 * JdbcUtil.close(rs); JdbcUtil.close(stmt); JdbcUtil.close(pstmt); } }
	 */
	
	// 삭제
	public int outuserDelete(Connection conn, int delNo) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement("delete from secession where sNo = ?")) {
			pstmt.setInt(1, delNo);
			return pstmt.executeUpdate();
		}
	}
}
