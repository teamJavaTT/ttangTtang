package mypage.likeProduct.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import auth.model.Product;
import jdbc.JdbcUtil;
import mypage.declarationAndBlockList.model.BlockColumn;
import mypage.declarationAndBlockList.model.DeclarationColumn;

public class LikeProductDao {

	public int likeProductCount(Connection conn, String userId) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(ino) from likeproduct where userid = '"+userId+"'");
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	
	public int likeProductUser(Connection conn, String userId, String ino) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(ino) from likeproduct where userid = '"+userId+"' and ino = "+ino);
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	
	// 신고 dao
	public ArrayList<String> likeProductSelect(Connection conn, String userId) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<String> result = new ArrayList<String>();
		try {
			pstmt = conn.prepareStatement("select * from likeproduct where userid = ?");
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				result.add(rs.getString("ino"));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public List<Product> likeDetailSelect(Connection conn, String likeList) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> result = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement("select * from product where ino in("+likeList+")");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				result.add(convertProduct(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	private Product convertProduct(ResultSet rs) throws SQLException {
		return new Product(rs.getString("ino"), rs.getString("userid"), rs.getString("ccode"), rs.getString("auctioncheck")
				,rs.getString("uad"), rs.getString("iname"), rs.getInt("price"), rs.getInt("minprice")
				,rs.getInt("maxprice"), rs.getInt("apricenow"), rs.getInt("apriceend"),rs.getString("pricetext"), rs.getString("imageface"), rs.getDate("endtime"));
	}

}
