package product.dao;

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

public class SearchDao {
	//상품 select
	public List<Product> selectSearchProduct(Connection conn, String search) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from product where iname like '%"+search+"%' or uad like '%"+search+"%' order by ino desc");
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
