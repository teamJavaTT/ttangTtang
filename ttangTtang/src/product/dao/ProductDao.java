package product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import auth.model.Product;
import jdbc.JdbcUtil;
import product.model.AucPro;
import product.model.NorPro;

public class ProductDao {

	// 경매 상품 등록
	public AucPro insertAuc(Connection conn, AucPro aucProduct) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(
					"INSERT INTO PRODUCT(INO, USERID, CCODE, CNAME, AUCTIONCHECK, UAD, INAME, PRICE,MINPRICE,MAXPRICE,APRICENOW,APRICEEND,PRICETEXT, IMAGEFACE, VIEWCOUNT, LIKECOUNT, PDATE,ENDTIME, REDATE, UDATE, SELLCHECK)"
							+ "VALUES(product_seq.NEXTVAL, '?', '?', '?', '?', '?','?', '?', '?', '?', '?', '?', '?', '?', 0, 0, sysdate,sysdate, sysdate, '?', '?')");

			pstmt.setString(7, aucProduct.getProduct_name());
			pstmt.setString(9, aucProduct.getMin_price());
			pstmt.setString(10, aucProduct.getMax_price());
			pstmt.setString(13, aucProduct.getDescription());
			pstmt.setString(14, aucProduct.getImageface());
			pstmt.setString(18, aucProduct.getEnd_time());

			return null;

		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}

	//일반 상품 등록
	public NorPro insertNor(Connection conn, NorPro norProduct) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(
					"INSERT INTO PRODUCT(INO, USERID, CCODE, CNAME, UAD, INAME, PRICE, PRICETEXT, IMAGEFACE, VIEWCOUNT, LIKECOUNT, PDATE, REDATE, UDATE, SELLCHECK)"
							+ "VALUES(product_seq.NEXTVAL, '?', '?', '?', '?','?', '?', '?', '?', 0, 0, sysdate, sysdate, '?', '?')");

			pstmt.setString(1, norProduct.getProduct_name());
			pstmt.setString(2, norProduct.getCategory());
			pstmt.setString(3, norProduct.getPrice());
			pstmt.setString(5, norProduct.getDescription());

			return null;

		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);

		}
	}

	//경매상품 업데이트 
	public AucPro updateAuc(Connection conn, AucPro aucProduct) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"update product set  product_name= ?, min_price = ?,max_price=?,description=? where ino = ?");
			pstmt.setString(1, aucProduct.getProduct_name());
			pstmt.setString(2, aucProduct.getMin_price());
			pstmt.setString(3, aucProduct.getMax_price());
			pstmt.setString(4, aucProduct.getDescription());
			pstmt.setString(5, aucProduct.getDescription());
			return null;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}

	//일반 상품 업데이트
	public NorPro updateNor(Connection conn, NorPro norProduct) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("update product set  product_name= ?, price = ?,description=? where ino = ?");
			pstmt.setString(1, norProduct.getProduct_name());
			pstmt.setString(2, norProduct.getPrice());
			pstmt.setString(3, norProduct.getDescription());
			return null;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}

	//경매 삭제 
	public int deleteAucPro(Connection conn, int delAuc) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement("delete from product where ino = ?")) {
			pstmt.setInt(1, delAuc);
			return pstmt.executeUpdate();
		}
	}

	//일반 삭제 
	public int deleteNorPro(Connection conn, int delNor) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement("delete from product where ino = ?")) {
			pstmt.setInt(1, delNor);
			return pstmt.executeUpdate();
		}
	}

	//검색상품 select
	public List<Product> selectSearchProduct(Connection conn, String[] searchArr) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String searchQuery = "";
		for (int i = 0; i < searchArr.length; i++) {
			if (i == 0) {
				searchQuery += "(iname like '%" + searchArr[i] + "%' or uad like '%" + searchArr[i] + "%')";
			} else {
				searchQuery += " and (iname like '%" + searchArr[i] + "%' or uad like '%" + searchArr[i] + "%')";
			}
		}

		try {
			pstmt = conn.prepareStatement("select * from product where " + searchQuery + " order by ino desc");
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

	//카테고리 검색 상품 select
	public List<Product> selectCategoryProduct(Connection conn, String categories) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from product where ccode='"+categories+"' order by ino desc");
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
		return new Product(rs.getString("ino"), rs.getString("userid"), rs.getString("cname"),
				rs.getString("auctioncheck"), rs.getString("uad"), rs.getString("iname"), rs.getString("price"),
				rs.getString("minprice"), rs.getString("maxprice"), rs.getString("pricetext"),
				rs.getString("imageface"), rs.getString("redate"));
	}
}
