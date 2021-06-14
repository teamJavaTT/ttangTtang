package admin.userinfo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import admin.userinfo.model.Userinfocolumn;
import jdbc.JdbcUtil;

public class UserInfoDao {
	
	// select 부분 시작
	
	public int selectCount(Connection conn) throws SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from member");
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		
	}
	
	
	public List<Userinfocolumn> userinfoSelect(Connection conn, int startNo, int endNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from(select  row_number() over (order by datetime desc) num, A.* from member A order by datetime desc) where num between ? and ?");
			pstmt.setInt(1, startNo);
			pstmt.setInt(2, endNo);
			rs = pstmt.executeQuery();
			List<Userinfocolumn> result = new ArrayList<>();
			while (rs.next()) {
				result.add(userinfoConvert(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public Userinfocolumn userinfoReadSelect(Connection conn, String id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from member where userid = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			Userinfocolumn userinfoColumn = null;
			if (rs.next()) {
				userinfoColumn = userinfoConvert(rs);
			}
			return userinfoColumn;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	private Userinfocolumn userinfoConvert(ResultSet rs) throws SQLException {
		return new Userinfocolumn(rs.getString("userId"), rs.getString("uEmail"), rs.getString("uName"), rs.getString("phone"), rs.getString("sex"), rs.getDate("dateTime"), rs.getInt("memberChk"));
	}
	// select 부분 끝
	
	//업데이트
	/*
	 * public Userinfocolumn useridUpdate(Connection conn, Userinfocolumn notice)
	 * throws SQLException { PreparedStatement pstmt = null; Statement stmt = null;
	 * ResultSet rs = null; try { pstmt =
	 * conn.prepareStatement("update userinfo set ftit = ?, ftext = ? where fno = ?"
	 * ); pstmt.setString(1, notice.getFtit()); pstmt.setString(2,
	 * notice.getFtext()); pstmt.setInt(3, notice.getFno()); int insertedCount =
	 * pstmt.executeUpdate();
	 * 
	 * if (insertedCount > 0) { stmt = conn.createStatement(); rs =
	 * stmt.executeQuery("select max(fno) from Userinfo"); if (rs.next()) { Integer
	 * newNo = rs.getInt(1); return new Userinfocolumn(newNo, notice.getFtit(),
	 * notice.getFtext(), notice.getFdate()); } } return null; }finally {
	 * JdbcUtil.close(rs); JdbcUtil.close(stmt); JdbcUtil.close(pstmt); } }
	 */
	
	// 삭제
	public int userinfoDelete(Connection conn, int delNo) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement(
						"delete from member where bNo = ?")) {
			pstmt.setInt(1, delNo);
			return pstmt.executeUpdate();
		}
	}
}
