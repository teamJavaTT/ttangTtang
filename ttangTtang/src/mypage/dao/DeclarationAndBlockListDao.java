package mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import mypage.model.BlockColumn;
import mypage.model.DeclarationColumn;

public class DeclarationAndBlockListDao {

	// 페이지 나눔 select
	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from declaration");
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	// 신고 dao
	public List<DeclarationColumn> declarationListCheckSelect(Connection conn, String userId, int startNo, int endNo)
			throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from(select row_number() over (order by dNo desc) num, A.* from declaration A where userid=? order by dNo desc) where num between ? and ?");
			pstmt.setString(1, userId);
			pstmt.setInt(2, startNo);
			pstmt.setInt(3, endNo);
			rs = pstmt.executeQuery();
			List<DeclarationColumn> result = new ArrayList<>();
			while (rs.next()) {
				result.add(declarationConvert(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	

	private DeclarationColumn declarationConvert(ResultSet rs) throws SQLException {
		return new DeclarationColumn(rs.getString("dNo"), rs.getString("userId"), rs.getString("duid"),
				rs.getString("dtext"), rs.getString("ddate"));
	}
	
	
	
	
	
	
	
	// 차단 dao
	public List<BlockColumn> blockListCheckSelect(Connection conn, String userId, int startNo, int endNo)
			throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from(select  row_number() over (order by bno desc) num, A.* from block A where userid=? order by bno desc) where num between ? and ?");
			pstmt.setString(1, userId);
			pstmt.setInt(2, startNo);
			pstmt.setInt(3, endNo);
			rs = pstmt.executeQuery();
			List<BlockColumn> result = new ArrayList<>();
			while (rs.next()) {
				result.add(blockConvert(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	  private BlockColumn blockConvert(ResultSet rs) throws SQLException { return
			  new BlockColumn(rs.getString("bNo"), rs.getString("userId"),
			  rs.getString("bid"), rs.getString("btext"), rs.getString("bdate")); }
	
	 
	  
	  /*
	 * public List<BlockColumn> CheckSelect(Connection conn, String userId, int
	 * startNo, int endNo) throws SQLException { PreparedStatement pstmt = null;
	 * ResultSet rs = null; try { pstmt = conn.prepareStatement(
	 * "select * from(select row_number() over (order by iNo desc) num, A.* from product A where userid=? order by iNo desc) where num between ? and ?"
	 * ); pstmt.setString(1, userId); pstmt.setInt(2, startNo); pstmt.setInt(3,
	 * endNo); rs = pstmt.executeQuery(); List<BlockColumn> result = new
	 * ArrayList<>(); while (rs.next()) { result.add(productConvert(rs)); } return
	 * result; } finally { JdbcUtil.close(rs); JdbcUtil.close(pstmt); } }
	 * 
	 * public List<BlockColumn> listCheckSelect(Connection conn, String userId,
	 * String sellChk, int startNo, int endNo) throws SQLException {
	 * PreparedStatement pstmt = null; ResultSet rs = null; try { pstmt =
	 * conn.prepareStatement(
	 * "select * from(select  row_number() over (order by ino desc) num, A.* from product A where userid=? and sellcheck = ? order by ino desc) where num between ? and ?"
	 * ); pstmt.setString(1, userId); pstmt.setString(2, sellChk); pstmt.setInt(3,
	 * startNo); pstmt.setInt(4, endNo); rs = pstmt.executeQuery();
	 * List<BlockColumn> result = new ArrayList<>(); while (rs.next()) {
	 * result.add(productConvert(rs)); } return result; } finally {
	 * JdbcUtil.close(rs); JdbcUtil.close(pstmt); } }
	 */
	
	
	 

}
