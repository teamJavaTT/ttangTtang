package auth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import admin.qna.model.Qnacolumn;
import auth.model.AuctionEnd;
import auth.model.Category;
import auth.model.Product;
import auth.model.ProductToday;
import jdbc.JdbcUtil;

public class MainDao {
	//카테고리 select
	public List<Category> selectCategory(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from category order by maincategory");
			rs = pstmt.executeQuery();
			List<Category> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertCategory(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}	
	private Category convertCategory(ResultSet rs) throws SQLException {
		return new Category(rs.getString("ccode"), rs.getString("cname"), rs.getString("maincategory"), rs.getString("middlecategory"));
	}
	
	//오늘의 상품 select
	public List<ProductToday> selectProductToday(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from(select  row_number() over (order by viewcount desc, ino) num, A.* from product A order by viewcount desc, ino) where num <=20");
			rs = pstmt.executeQuery();
			List<ProductToday> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertProductToday(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	private ProductToday convertProductToday(ResultSet rs) throws SQLException {
		return new ProductToday(rs.getString("ino"), rs.getString("userid"), rs.getString("ccode"), rs.getString("auctioncheck")
				,rs.getString("uad"), rs.getString("iname"), rs.getInt("price"), rs.getInt("minprice")
				,rs.getInt("maxprice"), rs.getString("pricetext"), rs.getString("imageface"), rs.getDate("endtime"));
	}
	
	//상품 select
	public List<Product> selectProduct(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from product where sellcheck='N' order by ino desc");
			rs = pstmt.executeQuery();
			List<Product> result = new ArrayList<>();
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
				,rs.getInt("maxprice"), rs.getInt("apricenow"), rs.getInt("apriceend"),rs.getString("pricetext"), rs.getString("imageface"),rs.getDate("endtime"));
	}
	
	public ArrayList<String> auctionEndInoSelect(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<String> result = new ArrayList<String>();
		try {
			pstmt = conn.prepareStatement("select * from product where sellcheck='N' and endtime <= sysdate");
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
	
	public void auctionEndUpdate(Connection conn, String likeList) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("update product set sellcheck = 'Y', apriceend = apricenow where ino in("+likeList+")");
			rs = pstmt.executeQuery();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public List<AuctionEnd> auctionEndInoCount(Connection conn, String likeList) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<AuctionEnd> result = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement("select ino, count(*) cnt from auction where ino in("+likeList+") group by ino");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				result.add(convertAuctionEnd(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	private AuctionEnd convertAuctionEnd(ResultSet rs) throws SQLException {
		return new AuctionEnd(rs.getString("ino"), rs.getInt("cnt"));
	}
	
	public String aucAlimUserIdSelect(Connection conn, String ino) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select userid from product where ino = ?");
			pstmt.setString(1, ino);
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getString("userid");
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public void alimInsert(Connection conn, String userId, String lText) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("insert into alim values(alim_seq.nextval, ?, ?, sysdate, 'N')");

			pstmt.setString(1, userId);
			pstmt.setString(2, lText);
			pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}
	
	public void auctioConnUpdate(Connection conn, String ino) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("update auction set conn = 'Y' where ino = ? and oprice = (select max(oprice) from auction where ino=?)");
			pstmt.setString(1, ino);
			pstmt.setString(2, ino);
			rs = pstmt.executeQuery();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public String aucConnUserIdSelect(Connection conn, String ino) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select userid from auction where  ino = ? and conn = 'Y'");
			pstmt.setString(1, ino);
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getString("userid");
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
}
