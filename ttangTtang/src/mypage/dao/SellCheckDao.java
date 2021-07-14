package mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import mypage.model.ProductColumn;

public class SellCheckDao {

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

	public List<ProductColumn> sellCheckSelect(Connection conn, String userId, int startNo, int endNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from(select row_number() over (order by iNo desc) num, A.* from product A where userid=? order by iNo desc) where num between ? and ?");
			pstmt.setString(1, userId);
			pstmt.setInt(2, startNo);
			pstmt.setInt(3, endNo);
			rs = pstmt.executeQuery();
			List<ProductColumn> result = new ArrayList<>();
			while (rs.next()) {
				result.add(productConvert(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public List<ProductColumn> sellCheckListSelect(Connection conn, String userId, String sellChk, int startNo, int endNo)
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
			List<ProductColumn> result = new ArrayList<>();
			while (rs.next()) {
				result.add(productConvert(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private ProductColumn productConvert(ResultSet rs) throws SQLException {
		return new ProductColumn(rs.getString("iNo"), rs.getString("userId"), rs.getString("cCode"),
				rs.getString("auctionCheck"), rs.getString("uad"), rs.getString("iName"), rs.getString("price"),
				rs.getString("minPrice"), rs.getString("maxPrice"), rs.getString("apriceNow"),
				rs.getString("apriceEnd"), rs.getString("priceText"), rs.getString("imageFace"),
				rs.getString("viewCount"), rs.getString("pDate"), rs.getString("endTime"),rs.getString("sellCheck"));
	}
	// select 부분 끝

	// 업데이트
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

}
