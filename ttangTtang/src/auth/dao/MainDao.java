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
		return new ProductToday(rs.getString("ino"), rs.getString("userid"), rs.getString("cname"), rs.getString("auctioncheck")
				,rs.getString("uad"), rs.getString("iname"), rs.getString("price"), rs.getString("minprice")
				,rs.getString("maxprice"), rs.getString("pricetext"), rs.getString("imageface"), rs.getString("redate"));
	}
	
	//상품 select
	public List<Product> selectProduct(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from product order by ino desc");
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
		return new Product(rs.getString("ino"), rs.getString("userid"), rs.getString("cname"), rs.getString("auctioncheck")
				,rs.getString("uad"), rs.getString("iname"), rs.getString("price"), rs.getString("minprice")
				,rs.getString("maxprice"), rs.getString("pricetext"), rs.getString("imageface"), rs.getString("redate"));
	}
	
}
