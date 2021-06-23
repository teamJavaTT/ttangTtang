package mypage.declarationAndBlockList.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import mypage.declarationAndBlockList.model.BlockColumn;
import mypage.declarationAndBlockList.model.DeclarationColumn;
import mypage.sellcheck.model.ProductColumn;

public class DeclarationAndBlockListDao {

	// select 부분 시작

	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from product");
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}

	public List<DeclarationColumn> CheckSelect(Connection conn, String userId, int startNo, int endNo)
			throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from(select row_number() over (order by iNo desc) num, A.* from product A where userid=? order by iNo desc) where num between ? and ?");
			pstmt.setString(1, userId);
			pstmt.setInt(2, startNo);
			pstmt.setInt(3, endNo);
			rs = pstmt.executeQuery();
			List<DeclarationColumn> result = new ArrayList<>();
			while (rs.next()) {
				result.add(productConvert(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public List<DeclarationColumn> listCheckSelect(Connection conn, String userId, String sellChk, int startNo, int endNo)
			throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from(select  row_number() over (order by ino desc) num, A.* from product A where userid=? and sellcheck = ? order by ino desc) where num between ? and ?");
			pstmt.setString(1, userId);
			pstmt.setString(2, sellChk);
			pstmt.setInt(3, startNo);
			pstmt.setInt(4, endNo);
			rs = pstmt.executeQuery();
			List<DeclarationColumn> result = new ArrayList<>();
			while (rs.next()) {
				result.add(productConvert(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private DeclarationColumn productConvert(ResultSet rs) throws SQLException {
		return new DeclarationColumn(rs.getString("dNo"), rs.getString("userId"), rs.getString("duid"),
				rs.getString("dtext"), rs.getString("ddate"));
	}
	// select 부분 끝

	
	
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
	/*
	 * private BlockColumn productConvert(ResultSet rs) throws SQLException { return
	 * new BlockColumn(rs.getString("bNo"), rs.getString("userId"),
	 * rs.getString("bid"), rs.getString("btext"), rs.getString("bdate")); }
	 */

}
