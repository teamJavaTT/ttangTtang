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
import product.service.AucProRequest;
import product.service.NorProRequest;

public class ProductDao {

	// 경매 상품 등록
	public AucPro insertAuc(Connection conn, AucProRequest aucProduct) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(
					"INSERT INTO PRODUCT(INO,USERID,CCODE,AUCTIONCHECK,UAD,INAME,MINPRICE,MAXPRICE,APRICENOW,PRICETEXT,IMAGEFACE,VIEWCOUNT,LIKECOUNT,PDATE,ENDTIME,AUCTIONTIME,SELLCHECK)"
							+ "VALUES(product_seq.NEXTVAL,?,?,'Y',null,?,?,?,?,?,?,0,0,sysdate,sysdate+"
							+ aucProduct.getAuctionTime() + "/24,?,'N')");
			pstmt.setString(1, aucProduct.getUserId()); // userId
			pstmt.setString(2, aucProduct.getCategory());// cname
			pstmt.setString(3, aucProduct.getProductName());// iname
			pstmt.setString(4, aucProduct.getMinPrice());// minPrice
			pstmt.setString(5, aucProduct.getMaxPrice());// MaxPrice
			pstmt.setString(6, aucProduct.getMinPrice());// APRICENOW
			pstmt.setString(7, aucProduct.getPriceText());// PriceTexe
			pstmt.setString(8, aucProduct.getImageFace());// ImageFace
			pstmt.setString(9, aucProduct.getAuctionTime());// AuctionTime
			pstmt.executeUpdate();

			return null;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}

	// 일반 상품 등록
	public NorPro insertNor(Connection conn, NorProRequest norProduct) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		String auctionCnk = "";
		if (norProduct.getCategory() == "BUY" || norProduct.getCategory().equals("BUY"))
			auctionCnk = "B";
		else
			auctionCnk = "N";

		try {
			pstmt = conn.prepareStatement(
					"INSERT INTO PRODUCT(INO,USERID,CCODE,AUCTIONCHECK,UAD,INAME,PRICE,PRICETEXT,IMAGEFACE,VIEWCOUNT,LIKECOUNT,PDATE,SELLCHECK)VALUES(product_seq.NEXTVAL,?,?,?,null,?,?,?,?,0,0,sysdate,'N')");

			pstmt.setString(1, norProduct.getUserId()); // userId
			pstmt.setString(2, norProduct.getCategory());
			pstmt.setString(3, auctionCnk);
			pstmt.setString(4, norProduct.getProductName());
			pstmt.setString(5, norProduct.getPrice());
			pstmt.setString(6, norProduct.getPriceText());
			pstmt.setString(7, norProduct.getImageFace());// ImageFace
			pstmt.executeUpdate();

			return null;

		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}

	// 경매상품 업데이트
	public AucPro updateAuc(Connection conn, AucPro upAuc) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"update product set  iname= ?, minprice = ?,maxprice=?,pricetext=? where ino = ?");
			pstmt.setString(1, upAuc.getIname());
			pstmt.setString(2, upAuc.getMinprice());
			pstmt.setString(3, upAuc.getMaxprice());
			pstmt.setString(4, upAuc.getPricetext());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
		return upAuc;
	}

	// 일반 상품 업데이트
	public NorPro updateNor(Connection conn, NorPro upNor) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("update product set iname= ?, price = ?, pricetext=? where ino = ?");
			pstmt.setString(1, upNor.getIname());
			pstmt.setString(2, upNor.getPrice());
			pstmt.setString(3, upNor.getPricetext());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
		return upNor;
	}

	// 경매 삭제
	public int deleteAucPro(Connection conn, int delNo) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement("delete from product where ino = ?")) {
			pstmt.setInt(1, delNo);

			return pstmt.executeUpdate();
		}
	}

	// 일반 삭제
	public int deleteNorPro(Connection conn, int delNo) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement("delete from product where ino = ?")) {
			pstmt.setInt(1, delNo);

			return pstmt.executeUpdate();
		}
	}

	// 검색상품 select
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

	// 카테고리 검색 상품 select
	public List<Product> selectCategoryProduct(Connection conn, String categories) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from product where ccode='" + categories + "' order by ino desc");
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
		return new Product(rs.getString("ino"), rs.getString("userid"), rs.getString("ccode"),
				rs.getString("auctioncheck"), rs.getString("uad"), rs.getString("iname"), rs.getInt("price"),
				rs.getInt("minprice"), rs.getInt("maxprice"), rs.getInt("apricenow"), rs.getInt("apriceend"),
				rs.getString("pricetext"), rs.getString("imageface"), rs.getDate("endtime"));
	}

// aucProDetail select
	public AucPro selectAucPro(Connection conn, int ino) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from product where ino =?");
			pstmt.setInt(1, ino);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String categoryPro = selectCategory(conn, rs.getString("ccode"));
				AucPro result = convertAucPro(rs, categoryPro);
				return result;
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return null;

	}

	private String selectCategory(Connection conn, String category) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select cname from category where ccode=?");
			pstmt.setString(1, category);
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getString("cname");
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private AucPro convertAucPro(ResultSet rs, String categoryPro) throws SQLException {
		return new AucPro(rs.getString("ino"), rs.getString("userid"), rs.getString("ccode"), categoryPro,
				rs.getString("auctioncheck"), rs.getString("uad"), rs.getString("iname"), rs.getString("price"),
				rs.getString("minprice"), rs.getString("maxprice"), rs.getString("apricenow"),
				rs.getString("apriceend"), rs.getString("pricetext"), rs.getString("imageface"),
				rs.getString("endtime"));
	}

	// norProDetail select
	public NorPro selectNorPro(Connection conn, int ino) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from product where ino =?");
			pstmt.setInt(1, ino);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String categoryPro = selectCategoryNor(conn, rs.getString("ccode"));
				NorPro result = converNorPro(rs, categoryPro);
				return result;
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return null;
	}

	private String selectCategoryNor(Connection conn, String category) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select cname from category where ccode=?");
			pstmt.setString(1, category);
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getString("cname");
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private NorPro converNorPro(ResultSet rs, String categoryPro) throws SQLException {
		return new NorPro(rs.getString("ino"), rs.getString("userid"), rs.getString("ccode"), categoryPro,
				rs.getString("auctioncheck"), rs.getString("iname"), rs.getString("price"), rs.getString("pricetext"),
				rs.getString("imageface"));
	}

	public AucPro auctionPartInsert(Connection conn, String userId, String aucIno, String oPrice) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO auction VALUES(ANO_SEQ.NEXTVAL,?,?,?)");
			pstmt.setString(1, userId);
			pstmt.setString(2, aucIno);
			pstmt.setString(3, oPrice);
			pstmt.executeUpdate();
			return null;
		} finally {
			JdbcUtil.close(pstmt);
		}
	}

}