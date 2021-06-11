package product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import admin.notice.model.Noticecolumn;
import jdbc.JdbcUtil;
import product.model.AucPro;

public class AucProDao {
	
	// 상품 등록
	public static AucPro insert(Connection conn, AucPro aucProduct) throws SQLException {
		PreparedStatement pstmt= null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO PRODUCT(INO, USERID, CCODE, CNAME, AUCTIONCHECK, UAD, INAME, PRICE,MINPRICE,MAXPRICE,APRICENOW,APRICEEND,PRICETEXT, IMAGEFACE, VIEWCOUNT, LIKECOUNT, PDATE,ENDTIME, REDATE, UDATE, SELLCHECK)"+"VALUES(product_seq.NEXTVAL, '?', '?', '?', '?', '?','?', '?', '?', '?', '?', '?', '?', '?', 0, 0, sysdate,sysdate, sysdate, '?', '?')");
			
			
			pstmt.setString(7,aucProduct.getProduct_name());
			pstmt.setString(9, aucProduct.getMin_price());
			pstmt.setString(10, aucProduct.getMax_price());
			pstmt.setString(13, aucProduct.getDescription());
			pstmt.setString(14, aucProduct.getImageface());
			pstmt.setString(18, aucProduct.getEnd_time());
			
			return null;
		
	}finally {
		JdbcUtil.close(rs);
		JdbcUtil.close(stmt);
		JdbcUtil.close(pstmt);
	}
	}

//상품 업데이트 
public AucPro updateAuc(Connection conn, AucPro aucProduct ) throws SQLException {
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	try {
		pstmt = conn.prepareStatement("update product set  product_name= ?, min_price = ?,max_price=?,description=? where ino = ?");
		pstmt.setString(1, aucProduct.getProduct_name());
		pstmt.setString(2, aucProduct.getMin_price());
		pstmt.setString(3, aucProduct.getMax_price());
		pstmt.setString(4, aucProduct.getDescription());
		pstmt.setString(5, aucProduct.getDescription());
	return null;
	}finally {
		JdbcUtil.close(rs);
		JdbcUtil.close(stmt);
		JdbcUtil.close(pstmt);
	}
}
//삭제 
public int deleteAucPro(Connection conn, int delAuc) throws SQLException {
	try (PreparedStatement pstmt = 
			conn.prepareStatement(
					"delete from product where ino = ?")) {
		pstmt.setInt(1, delAuc);
		return pstmt.executeUpdate();
	}
}
}

// 2번 기능 : 전체 상품 조회 기능
