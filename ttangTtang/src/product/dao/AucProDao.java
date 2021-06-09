package product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.JdbcUtil;
import product.model.AucPro;

public class AucProDao {
	
	// 상품 등록
	public static AucPro insert(Connection conn, AucPro aucProduct) throws SQLException {
		PreparedStatement pstmt= null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO PRODUCT(INO, USERID, CCODE, CNAME, AUCTIONCHECK, UAD, INAME, PRICE, PRICETEXT, IMAGEFACE, VIEWCOUNT, LIKECOUNT, PDATE, REDATE, UDATE, SELLCHECK)"+"VALUES(product_seq.NEXTVAL, '?', '?', '?', '?', '?', '?', '?', '?', '?', 0, 0, sysdate, sysdate, '?', '?')");
			
			pstmt.setString(1,aucProduct.getProduct_name());
			pstmt.setString(3, aucProduct.getMax_price());
			pstmt.setString(2, aucProduct.getMin_price());
			pstmt.setString(4, aucProduct.getEnd_time());
			pstmt.setString(5, aucProduct.getDescription());
			
			return null;
		
	}finally {
		JdbcUtil.close(rs);
		JdbcUtil.close(stmt);
	
	}
	}
}



// 2번 기능 : 전체 상품 조회 기능
