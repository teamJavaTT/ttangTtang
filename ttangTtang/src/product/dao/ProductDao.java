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
			pstmt = conn.prepareStatement("INSERT INTO PRODUCT(INO,USERID,CCODE,AUCTIONCHECK,UAD,INAME,MINPRICE,MAXPRICE,PRICETEXT,IMAGEFACE,VIEWCOUNT,LIKECOUNT,PDATE,ENDTIME,AUCTIONTIME,SELLCHECK)"
										+ "VALUES(product_seq.NEXTVAL,?,?,'Y',null,?,?,?,?,?,0,0,sysdate,sysdate+"+aucProduct.getAuctionTime()+"/24,?,'N')");
			pstmt.setString(1, aucProduct.getUserId()); //userId
			pstmt.setString(2, aucProduct.getCategory());//cname
			pstmt.setString(3, aucProduct.getProductName());//iname
			pstmt.setString(4, aucProduct.getMinPrice());//minPrice
			pstmt.setString(5, aucProduct.getMaxPrice());//MaxPrice
			pstmt.setString(6, aucProduct.getPriceText());//PriceTexe
			pstmt.setString(7, aucProduct.getImageFace());//ImageFace
			pstmt.setString(8,aucProduct.getAuctionTime());//AuctionTime
			pstmt.executeUpdate();
			
			return null;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}
		


	//일반 상품 등록
	public NorPro insertNor(Connection conn, NorProRequest norProduct) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(
"INSERT INTO PRODUCT(INO,USERID,CCODE,UAD,INAME,PRICE,PRICETEXT,IMAGEFACE,VIEWCOUNT,LIKECOUNT,PDATE,REDATE,SELLCHECK)VALUES(product_seq.NEXTVAL,?,?,null,?,?,?,?,0,0,sysdate,sysdate,'N')");

			pstmt.setString(1, norProduct.getUserId()); //userId
			pstmt.setString(2, norProduct.getCategory());
			pstmt.setString(3, norProduct.getProductName());
			pstmt.setString(4, norProduct.getPrice());
			pstmt.setString(5, norProduct.getPriceText());
			pstmt.setString(6, norProduct.getImageFace());//ImageFace
			pstmt.executeUpdate();
			
			return null;

		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}

	//경매상품 업데이트 
	public AucPro updateAuc(Connection conn, AucPro aucProduct) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"update product set  iname= ?, minprice = ?,maxprice=?,pricetext=? where ino = ?");
			pstmt.setString(1, aucProduct.getIname());
			pstmt.setString(2, aucProduct.getMinprice());
			pstmt.setString(3, aucProduct.getMaxprice());
			pstmt.setString(4, aucProduct.getPricetext());
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
			pstmt = conn.prepareStatement("update product set iname= ?, price = ?, pricetext=? where ino = ?");
			pstmt.setString(1, norProduct.getIname());
			pstmt.setString(2, norProduct.getPrice());
			pstmt.setString(3, norProduct.getPricetext());
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
		return new Product(rs.getString("ino"), rs.getString("userid"), rs.getString("ccode"),
				rs.getString("auctioncheck"), rs.getString("uad"), rs.getString("iname"), rs.getString("price"),
				rs.getString("minprice"), rs.getString("maxprice"),rs.getString("apricenow"), rs.getString("apriceend"), rs.getString("pricetext"),
				rs.getString("imageface"));
	}
// aucPro select

	public List<AucPro> selecAucPro(Connection conn) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select*from product where ino = ?");
			rs = pstmt.executeQuery();
			List<AucPro> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertAucPro(rs));
			}return result;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
	}
	private AucPro convertAucPro(ResultSet rs) throws SQLException{
		return new AucPro(rs.getString("ino"),rs.getString("userid"), rs.getString("ccode"),
				rs.getString("auctioncheck"), rs.getString("uad"), rs.getString("iname"), rs.getString("price"),
				rs.getString("minprice"), rs.getString("maxprice"),rs.getString("apricenow"), rs.getString("apriceend"), rs.getString("pricetext"),
				rs.getString("imageface"),rs.getString("endtime"));
	}
//norPro select
public List<NorPro> selecNorPro(Connection conn) throws SQLException{
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
		pstmt = conn.prepareStatement("select*from product where ino = ?");
		rs = pstmt.executeQuery();
		List<NorPro> result = new ArrayList<>();
		while (rs.next()) {
			result.add(converNorPro(rs));
		}return result;
	}finally {
		JdbcUtil.close(rs);
		JdbcUtil.close(pstmt);
	}
	
}
private NorPro converNorPro(ResultSet rs) throws SQLException{
	return new NorPro(rs.getString("ino"),rs.getString("userid"),rs.getString("ccode"),rs.getString("iname"), rs.getString("price"),rs.getString("pricetext"),
			rs.getString("imageface"));
}



}