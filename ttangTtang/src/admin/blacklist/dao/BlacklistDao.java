package admin.blacklist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import admin.blacklist.model.Blacklistcolumn;
import jdbc.JdbcUtil;

public class BlacklistDao {
	
	// select 부분 시작
	
	public int selectCount(Connection conn) throws SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from block");
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		
	}
	
	public List<Blacklistcolumn> blacklistSelect(Connection conn, int startNo, int endNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from(select  row_number() over (order by bdate desc) num, A.* from block A order by bdate desc) where num between ? and ?");
			pstmt.setInt(1, startNo);
			pstmt.setInt(2, endNo);
			rs = pstmt.executeQuery();
			List<Blacklistcolumn> result = new ArrayList<>();
			while (rs.next()) {
				result.add(blacklistConvert(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public Blacklistcolumn blacklistReadSelect(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from block where bNo = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			Blacklistcolumn blacklistColumn = null;
			if (rs.next()) {
				blacklistColumn = blacklistConvert(rs);
			}
			return blacklistColumn;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	private Blacklistcolumn blacklistConvert(ResultSet rs) throws SQLException {
		return new Blacklistcolumn(rs.getInt("bNo"), rs.getString("userId"), rs.getString("bId"), rs.getString("bText"), rs.getDate("bDate"));
	}
	// select 부분 끝
	
	//업데이트
	/*
	 * public Blacklistcolumn useridUpdate(Connection conn, Blacklistcolumn notice)
	 * throws SQLException { PreparedStatement pstmt = null; Statement stmt = null;
	 * ResultSet rs = null; try { pstmt =
	 * conn.prepareStatement("update blacklist set ftit = ?, ftext = ? where fno = ?"
	 * ); pstmt.setString(1, notice.getFtit()); pstmt.setString(2,
	 * notice.getFtext()); pstmt.setInt(3, notice.getFno()); int insertedCount =
	 * pstmt.executeUpdate();
	 * 
	 * if (insertedCount > 0) { stmt = conn.createStatement(); rs =
	 * stmt.executeQuery("select max(fno) from Blacklist"); if (rs.next()) { Integer
	 * newNo = rs.getInt(1); return new Blacklistcolumn(newNo, notice.getFtit(),
	 * notice.getFtext(), notice.getFdate()); } } return null; }finally {
	 * JdbcUtil.close(rs); JdbcUtil.close(stmt); JdbcUtil.close(pstmt); } }
	 */
	
	// 삭제
	public int blacklistDelete(Connection conn, int delNo) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement(
						"delete from block where bNo = ?")) {
			pstmt.setInt(1, delNo);
			return pstmt.executeUpdate();
		}
	}
}
